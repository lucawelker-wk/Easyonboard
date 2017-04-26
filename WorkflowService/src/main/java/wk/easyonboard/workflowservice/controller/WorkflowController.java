package wk.easyonboard.workflowservice.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/workflow")
public class WorkflowController {
    @Path("/start")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID startWorkflow(@FormParam("workflowId") String workflowId, @FormParam("employeeId") String employeeId) {
        return UUID.randomUUID();
    }
}
