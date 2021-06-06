package leoli.hotswap.plugin.web.bean;

import lombok.Data;

import java.util.List;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Data
public class Plugins {

    private List<PluginConfig> configs;

    private String name;

}
