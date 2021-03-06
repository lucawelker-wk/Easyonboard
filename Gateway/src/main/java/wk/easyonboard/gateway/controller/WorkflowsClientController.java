package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.WorkflowDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/workflows")
public class WorkflowsClientController extends BaseClientController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WorkflowDTO> getWorkflows() {
        return buildAdminClient()
                .path("workflows")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<WorkflowDTO>>() {
                });
    }

    @Path("/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getWorkflowCount() {
        return buildAdminClient()
                .path("workflows")
                .path("count")
                .request(MediaType.TEXT_PLAIN)
                .buildGet()
                .invoke(Integer.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createWorkflow(WorkflowDTO workflow) {
        return buildAdminClient()
                .path("workflows")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.entity(workflow, MediaType.APPLICATION_JSON_TYPE))
                .invoke(UUID.class);
    }
}
