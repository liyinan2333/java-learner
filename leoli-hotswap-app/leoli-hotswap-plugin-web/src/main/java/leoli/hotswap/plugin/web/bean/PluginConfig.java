package leoli.hotswap.plugin.web.bean;

import lombok.Data;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Data
public class PluginConfig {

    private boolean active;
    private String className;
    private String id;
    private String jarRemoteUrl;
    private String name;
    private boolean enabled;

}
