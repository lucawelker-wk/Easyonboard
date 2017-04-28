package wk.easyonboard.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Api(value = "/api/employees", description = "Access to employees")
@Path("/api/employees")
public class EmployeesClientController extends BaseClientController {

    @ApiOperation(value = "Gets all employees", response = EmployeeDTO.class)
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

    @ApiOperation(value = "Gets the all employees count", response = Integer.class)
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

    @ApiOperation(value = "Creates a new employee", notes = "Returns the id of the newly created employee", response = UUID.class)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createEmployee(EmployeeDTO data) {
        return buildAdminClient()
                .path("employees")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE))
                .invoke(UUID.class);
    }
}
