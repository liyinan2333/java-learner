package leoli.springboot.autoconfiguration.aspectlog;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件类
 *
 * @author leoli
 * @date 2020/8/10
 */
@ConfigurationProperties("aspectLog")
public class AspectLogProperties {

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
