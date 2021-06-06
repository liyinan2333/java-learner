package leoli.hotswap.plugin.web.spi;

import cn.hutool.core.io.FileUtil;
import com.google.gson.Gson;
import leoli.hotswap.plugin.web.bean.PluginConfig;
import leoli.hotswap.plugin.web.bean.Plugins;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Component
public class DefaultPluginFactory implements ApplicationContextAware {

    private static final String configPath = "../config/plugins.json";
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPluginFactory.class);


    private ApplicationContext applicationContext;
    private Map<String, PluginConfig> configs = new HashMap<>();
    private Map<String, Advice> adviceCache = new HashMap<>();
    private Gson GSON = new Gson();

    /**
     * 激活插件
     *
     * @param id
     */
    public void activePlugin(String id) {
        if (!configs.containsKey(id)) {
            throw new RuntimeException(String.format("指定插件不存在 id=%s", id));
        }
        PluginConfig config = configs.get(id);
        config.setActive(true);

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
        if (!configs.containsKey(id)) {
            throw new RuntimeException(String.format("指定插件不存在 id=%s", id));
        }
        PluginConfig config = configs.get(id);
        // 设置为不生效,页面也不显示
        config.setActive(false);
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

    public Advice buildAdvice(PluginConfig config) throws Exception {
        if (adviceCache.containsKey(config.getClassName())) {
            return adviceCache.get(config.getClassName());
        }
        // 获取本地待加载的jar插件包路径
        URL targetUrl = new URL(config.getJarRemoteUrl());
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


    public Collection<PluginConfig> flushConfigs() throws IOException {
        File file = new File(configPath);
        String configJson = FileUtil.readUtf8String(file);
        Plugins pluginConfigs = GSON.fromJson(configJson, Plugins.class);
        for (PluginConfig pluginConfig : pluginConfigs.getConfigs()) {
            if (configs.get(pluginConfig.getId()) == null) {
                configs.put(pluginConfig.getId(), pluginConfig);
            }
        }
        return configs.values();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
