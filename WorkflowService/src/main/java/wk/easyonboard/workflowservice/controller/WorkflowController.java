package wk.easyonboard.workflowservice.controller;

import wk.easyonboard.common.datatransfer.WorkflowDTO;
import wk.easyonboard.workflowservice.services.AdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/workflow/{workflowId}")
public class WorkflowController {
    private AdminService adminService = new AdminService();

    @Path("/start/{employeeId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID startWorkflow(@PathParam("workflowId") String workflowId, @PathParam("employeeId") String employeeId) {
        WorkflowDTO workflow = adminService.getWorkflow(UUID.fromString(workflowId));
        return UUID.randomUUID();
    }
}
