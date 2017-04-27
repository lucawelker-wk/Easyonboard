package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.adminservice.data.dto.Workflow;
import wk.easyonboard.common.datatransfer.WorkflowDTO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/workflows")
public class WorkflowController {
    @GET
    public List<WorkflowDTO> getWorkflows() {
        final List<Workflow> workflows = RepositoryCache.getWorkflowRepository().readAll();

        return workflows.stream()
                .map(Workflow::toServerDTO)
                .collect(Collectors.toList());
    }

    @Path("/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getWorkflowCount() {
        return RepositoryCache.getWorkflowRepository().readAll().size();
    }

    @POST
    public boolean createWorkflow(WorkflowDTO workflow) throws IllegalAccessException {
        workflow.setId(UUID.randomUUID());
        return RepositoryCache.getWorkflowRepository().create(Workflow.fromServerDTO(workflow));
    }
}
