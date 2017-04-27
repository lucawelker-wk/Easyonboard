package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/employees")
public class EmployeeClientController extends BaseClientController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDTO> getEmployees() {
        final List<EmployeeDTO> employees = buildAdminClient()
                .path("employees")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<EmployeeDTO>>() {
                });

        return employees;
    }

    @Path("count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getEmployeeCount() {
        return buildAdminClient()
                .path("employees")
                .path("count")
                .request(MediaType.TEXT_PLAIN)
                .buildGet()
                .invoke(Integer.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean createEmployee(EmployeeDTO data) {
        final Response employees = buildAdminClient()
                .path("employees")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE))
                .invoke();

        return employees.getStatusInfo().getStatusCode() == 200;
    }
}
