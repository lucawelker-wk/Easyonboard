package wk.easyonboard.grizzlylauncher;


import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
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
            startSwagger().start();
            grizzlyLauncher.startServices(grizzlyLauncher.provideServices());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpServer startSwagger() {
        URI baseUri = UriBuilder.fromUri("http://localhost")
                .port(8999)
                .build();

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setBasePath("http://localhost:9080/api");
        beanConfig.setResourcePackage("wk.easyonboard.gateway.controller");
        beanConfig.setScan(true);


        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri,
                new ResourceConfig(SwaggerSerializers.class, ApiListingResource.class));

//        WebappContext context = new WebappContext("SwaggerUI");
//
//        ServletRegistration registration = context.addServlet("ServletContainer", ServletContainer.class);
//        registration.addMapping("/swagger");
//        //registration.setInitParameter("javax.ws.rs.Application", SwaggerBootstrap.class.getName());
//        context.deploy(server);

        return server;
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
