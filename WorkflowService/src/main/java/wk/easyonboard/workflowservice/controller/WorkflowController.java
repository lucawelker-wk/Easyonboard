package wk.easyonboard.workflowservice.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/workflow/{workflowId}")
public class WorkflowController {
    @Path("/start/{employeeId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID startWorkflow(@PathParam("workflowId") String workflowId, @PathParam("employeeId") String employeeId) {
        return UUID.randomUUID();
    }
}
