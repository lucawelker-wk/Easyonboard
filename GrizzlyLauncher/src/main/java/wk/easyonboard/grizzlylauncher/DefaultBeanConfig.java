package wk.easyonboard.grizzlylauncher;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * Created by Luca Welker on 4/28/17.
 */
public class DefaultBeanConfig extends BeanConfig {
    public DefaultBeanConfig() {
        setVersion("1.0.2");
        setBasePath("http://localhost:9080");
        setResourcePackage("wk.easyonboard.gateway.controller");
        setScan(true);
    }
}
