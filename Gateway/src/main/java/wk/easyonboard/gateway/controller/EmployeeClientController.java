package wk.easyonboard.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Api(value = "/api/employee/{employeeId}", description = "Access to a employee")
@Path("/api/employee/{employeeId}")
public class EmployeeClientController extends BaseClientController {

    @ApiOperation(value = "Gets a employee", notes = "Gets the requested employee with {employeeId}", response = EmployeeDTO.class)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDTO getEmployee(@PathParam("employeeId") UUID employeeId) {
        return buildAdminClient()
                .path("employee")
                .path(employeeId.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(EmployeeDTO.class);
    }

    @ApiOperation(value = "Get the currently running workflows for a employee", notes = "Return a list of running workflow IDs", response = UUID.class)
    @GET
    @Path("runningWorkflows")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UUID> getWorkflowStatusForEmployee(@PathParam("employeeId") UUID employeeId) {
        return buildWorkflowClient()
                .path("workflow")
                .path("employee")
                .path(employeeId.toString())
                .path("runningWorkflows")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<UUID>>() { });
    }
}
