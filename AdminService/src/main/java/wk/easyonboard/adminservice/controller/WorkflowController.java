package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.common.datatransfer.WorkflowDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Path("/workflow/{workflowId}")
public class WorkflowController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WorkflowDTO getWorkflow(@PathParam("workflowId") UUID workflowId) throws InstantiationException, IllegalAccessException {
        return RepositoryCache.getWorkflowRepository().read(workflowId).toServerDTO();
    }
}
