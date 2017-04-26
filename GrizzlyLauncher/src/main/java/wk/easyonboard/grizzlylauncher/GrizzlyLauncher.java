package wk.easyonboard.grizzlylauncher;


import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import wk.easyonboard.adminservice.AdminService;
import wk.easyonboard.common.Launchable;
import wk.easyonboard.gateway.Gateway;
import wk.easyonboard.workflowservice.WorkflowService;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by wkss on 4/26/17.
 */
public class GrizzlyLauncher {
    private static final String BASEHOST = "http://localhost";

    public static void main(String[] params) {
        Locale.setDefault(Locale.ENGLISH);

        final GrizzlyLauncher grizzlyLauncher = new GrizzlyLauncher();
        try {
            grizzlyLauncher.startServices(grizzlyLauncher.provideServices());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<Class<? extends Launchable>> provideServices() {
        Set<Class<? extends Launchable>> services = new HashSet<Class<? extends Launchable>>();
        services.add(AdminService.class);
        services.add(Gateway.class);
        services.add(WorkflowService.class);
        return services;
    }

    private void startServices(Set<Class<? extends Launchable>> services) throws InstantiationException, IllegalAccessException, IOException {
        for (Class<? extends Launchable> service : services) {
            HttpServer server = createEndpoint(service);
            server.start();
        }
    }

    private HttpServer createEndpoint(Class<? extends Launchable> service) throws IllegalAccessException, InstantiationException {
       Launchable serviceInstance = service.newInstance();

        final URI host = UriBuilder.fromUri(BASEHOST)
                .port(serviceInstance.getPortNr())
                .build();

        ResourceConfig config = new ResourceConfig(serviceInstance.getResources())
                .register(GensonJsonConverter.class);

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(host, config);
        return server;
    }
}
