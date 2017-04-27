package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.BaseClientController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/workflow/{workflowId}")
public class WorkflowClientController extends BaseClientController {
    @POST
    @Path("start/{employeeId}")
    public UUID startWorkflow(@PathParam("workflowId") UUID workflowId, @PathParam("employeeId") UUID employeeId) {
        return buildWorkflowClient()
                .path("workflow")
                .path(workflowId.toString())
                .path("start")
                .path(employeeId.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(null)
                .invoke(UUID.class);
    }
}
