package wk.easyonboard.workflowservice.controller;

import wk.easyonboard.workflowservice.dataaccess.RepositoryCache;
import wk.easyonboard.workflowservice.dataaccess.RunningWorkflow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/28/17.
 */
@Path("/workflow/employee/{employeeId}")
public class EmployeeController {
    @GET
    @Path("runningWorkflows")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UUID> getRunningWorkflowsForEmployee(@PathParam("employeeId") UUID employeeId) {
        final List<RunningWorkflow> workflowsForEmployee = RepositoryCache.getRunningWorkflowsRepository().getWorkflowsForEmployee(employeeId);

        return workflowsForEmployee.stream()
                .map(x -> x.getId())
                .collect(Collectors.toList());
    }
}
