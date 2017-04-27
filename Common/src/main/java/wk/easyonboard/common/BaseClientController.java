package wk.easyonboard.common;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by Luca Welker on 4/26/17.
 */
public abstract class BaseClientController {
    private static final String BASE_HOST = "http://localhost";

    protected WebTarget buildAdminClient() {
        return buildClient(ServiceConstants.ADMINSERVICE_PORT);
    }

    protected WebTarget buildWorkflowClient() {
        return buildClient(ServiceConstants.WORKFLOWSERVICE_PORT);
    }

    private WebTarget buildClient(int port) {
        ClientConfig config = new ClientConfig(GensonJsonConverter.class);
        return ClientBuilder.newClient(config)
                .target(UriBuilder.fromUri(BASE_HOST).port(port).build());
    }
}
