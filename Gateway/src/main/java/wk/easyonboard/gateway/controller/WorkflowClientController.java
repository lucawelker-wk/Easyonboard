package wk.easyonboard.gateway.controller;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/workflow")
public class WorkflowClientController extends BaseClientController {
    @Path("/start")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public UUID startWorkflow(@FormParam("workflowId")UUID workflowId, @FormParam("employeeId") UUID employeeId) {
        MultivaluedMap formData = new MultivaluedHashMap();
        formData.add("workflowId", workflowId.toString());
        formData.add("employeeId", employeeId.toString());

        return buildWorkflowClient()
                .path("workflow")
                .path("start")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.form(formData))
                .invoke(UUID.class);
    }
}
