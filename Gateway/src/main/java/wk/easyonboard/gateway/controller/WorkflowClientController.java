package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.WorkflowItemStatusDTO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/workflow")
public class WorkflowClientController extends BaseClientController {
    @POST
    @Path("/{workflowId}/start/{employeeId}")
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

    @GET
    @Path("/{workflowRunningId}/status")
    public List<WorkflowItemStatusDTO> getWorkflowRunningStatus(@PathParam("workflowRunningId") UUID workflowRunningId) {
        return buildWorkflowClient()
                .path("workflow")
                .path(workflowRunningId.toString())
                .path("status")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<WorkflowItemStatusDTO>>() {
                });
    }
}
