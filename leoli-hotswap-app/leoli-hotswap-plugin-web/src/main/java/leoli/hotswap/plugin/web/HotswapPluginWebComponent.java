package leoli.hotswap.plugin.web;

import leoli.hotswap.plugin.web.spi.DefaultPluginFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 插件web管理模块
 *
 * @author leoli
 * @date 2021/6/11
 */
@Component
public class HotswapPluginWebComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotswapPluginWebComponent.class);

    @Autowired
    private DefaultPluginFactory pluginFactory;

    @PostConstruct
    public void init() {
        // 初始化插件配置
        initPluginWebManager();
    }

    private void initPluginWebManager() {
        try {
            pluginFactory.flushConfigs();
        } catch (Exception e) {
            LOGGER.error("Plugin web module init failure." + e.getMessage(), e);
        }
    }

}
