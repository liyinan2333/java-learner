package leoli.hotswap.plugin.web.spi;

import cn.hutool.core.io.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import leoli.hotswap.plugin.web.bean.Plugin;
import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Component
public class DefaultPluginFactory implements ApplicationContextAware {

    private static final String configPath = "../config/plugins.json";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPluginFactory.class);


    private ApplicationContext applicationContext;
    private Map<String, Plugin> pluginCache = new HashMap<>();
    private Map<String, Advice> adviceCache = new HashMap<>();
    private Gson GSON = new Gson();

    /**
     * 激活插件
     *
     * @param id
     */
    public void enablePlugin(String id) {
        if (!pluginCache.containsKey(id)) {
            throw new RuntimeException(String.format("指定插件不存在 id=%s", id));
        }
        Plugin config = pluginCache.get(id);
        config.setEnabled(true);

        // 把bean的定义全部遍历出来
        for (String name : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(name);
            if (bean == this) {
                continue;
            }
            if (!(bean instanceof Advised)) {
                continue;
            }
            if (findAdvice((Advised) bean, config.getClassName()) != null) {
                continue;
            }
            // 业务类的方法
            Advice advice = null;
            try {
                advice = buildAdvice(config);
                // 实现了拦截
                ((Advised) bean).addAdvice(advice);
            } catch (Exception e) {
                throw new RuntimeException("安装失败", e);
            }
        }
    }

    public void disablePlugin(String id) {
        if (!pluginCache.containsKey(id)) {
            throw new RuntimeException(String.format("指定插件不存在 id=%s", id));
        }
        Plugin config = pluginCache.get(id);
        // 设置为不生效,页面也不显示
        config.setEnabled(false);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(name);
            if (bean instanceof Advised) {
                Advice advice = findAdvice((Advised) bean, config.getClassName());
                if (advice != null) {
                    ((Advised) bean).removeAdvice(advice);
                }
            }
        }
    }

    /**
     * 查切面
     *
     * @param advised
     * @param className
     * @return
     */
    private Advice findAdvice(Advised advised, String className) {
        for (Advisor a : advised.getAdvisors()) {
            if (a.getAdvice().getClass().getName().equals(className)) {
                return a.getAdvice();
            }
        }
        return null;
    }

    public Advice buildAdvice(Plugin config) throws Exception {
        if (adviceCache.containsKey(config.getClassName())) {
            return adviceCache.get(config.getClassName());
        }
        // 获取本地待加载的jar插件包路径
        URL targetUrl = new URL("file:/" + config.getJarRemoteUrl());
        // 获取当前正在运行的项目,加载了哪些jar包
        URLClassLoader loader = (URLClassLoader) getClass().getClassLoader();
        boolean isLoader = false;
        for (URL url : loader.getURLs()) {
            // 判断当前加载的jar包是否已经被加载到loader
            if (url.equals(targetUrl)) {
                isLoader = true;
                break;
            }
        }
        // 如果插件jar包没有被加载到loader,则调用add.invoke将jar加载进来
        if (!isLoader) {
            Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
            add.setAccessible(true);
            // 加载本地jar
            add.invoke(loader, targetUrl);
        }
        // 将插件jar包里的leoli.hotswap.plugin.CountTimesPlugin类,创建Class对象
        Class<?> adviceClass = loader.loadClass(config.getClassName());
        // adviceClass对象通过反射创建advice拦截对象
        adviceCache.put(adviceClass.getName(), (Advice) adviceClass.getConstructor().newInstance());
        // 返回advice对象
        return adviceCache.get(adviceClass.getName());
    }


    public List<Plugin> flushConfigs() throws IOException {
        File file = new File(configPath);
        String configJson = FileUtil.readUtf8String(file);
        List<Plugin> fileConfigs = GSON.fromJson(configJson, new TypeToken<List<Plugin>>(){}.getType());
        for (Plugin plugin : fileConfigs) {
            // 添加缓存
            if (pluginCache.get(plugin.getId()) == null) {
                pluginCache.put(plugin.getId(), plugin);
                // 设置默认状态
                if (plugin.isEnabled()) {
                    enablePlugin(plugin.getId());
                } else {
                    disablePlugin(plugin.getId());
                }
            }
        }
        return pluginCache.values().stream().collect(Collectors.toList());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
