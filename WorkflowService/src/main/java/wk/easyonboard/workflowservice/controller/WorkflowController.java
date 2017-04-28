package wk.easyonboard.workflowservice.controller;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.WorkflowDTO;
import wk.easyonboard.common.datatransfer.WorkflowItemDTO;
import wk.easyonboard.common.datatransfer.WorkflowItemStatusDTO;
import wk.easyonboard.workflowservice.dataaccess.RepositoryCache;
import wk.easyonboard.workflowservice.dataaccess.RunningWorkflow;
import wk.easyonboard.workflowservice.dataaccess.RunningWorkflowItem;
import wk.easyonboard.workflowservice.services.AdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/workflow")
public class WorkflowController {
    private AdminService adminService = new AdminService();

    @Path("{workflowId}/start/{employeeId}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID startWorkflow(@PathParam("workflowId") String workflowId, @PathParam("employeeId") String employeeId) throws IllegalAccessException {
        WorkflowDTO workflow = adminService.getWorkflow(UUID.fromString(workflowId));
        EmployeeDTO employee = adminService.getEmployee(UUID.fromString(employeeId));

        if (workflow == null) {
            throw new IllegalArgumentException("workflowId not found");
        }

        if (employee == null) {
            throw new IllegalArgumentException("employeeId not found");
        }

        RunningWorkflow runningWorkflow = new RunningWorkflow();
        runningWorkflow.setEmployeeId(employee.getId());
        runningWorkflow.setWorkflowId(workflow.getId());

        UUID runningId = RepositoryCache.getRunningWorkflowsRepository().createWorkflowRun(runningWorkflow);

        updateWorkflowItems(workflow, runningId);

        return runningId;
    }

    @Path("/employeeStatus/{employeeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UUID getRunningWorkflowForEmployee(@PathParam("employeeId") UUID employeeId) {
        final Optional<RunningWorkflow> first = RepositoryCache.getRunningWorkflowsRepository().getWorkflowsForEmployee(employeeId).stream().findFirst();

        return first.isPresent() ? first.get().getId() : null;
    }

    @Path("/{workflowRunningId}/status")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WorkflowItemStatusDTO> getStatusForRunningWorkflow(@PathParam("workflowRunningId") UUID workflowRunningId) throws InstantiationException, IllegalAccessException {
        final List<RunningWorkflowItem> runningWorkflowItems = RepositoryCache.getRunningWorkflowItemRepository().readMany(ImmutableMap.of("runningWorkflowId", workflowRunningId));

        return runningWorkflowItems.stream()
                .map(x -> {
                    WorkflowItemStatusDTO status = new WorkflowItemStatusDTO();
                    status.setRunningWorkflowId(workflowRunningId);
                    status.setWorkflowItemId(x.getWorkflowItemId());
                    status.setOriginalWorkflowId(x.getWorkflowId());
                    status.setDueDate(x.getDueDate());
                    status.setSuccess(x.getSuccess());

                    return status;
                }).collect(Collectors.toList());
    }

    private void updateWorkflowItems(WorkflowDTO workflow, UUID runningId) throws IllegalAccessException {
        boolean first = true;
        for (WorkflowItemDTO item : workflow.getItems()) {
            RunningWorkflowItem runningItem = new RunningWorkflowItem();
            runningItem.setId(UUID.randomUUID());
            runningItem.setWorkflowId(workflow.getId());
            runningItem.setWorkflowItemId(item.getId());
            runningItem.setRunningWorkflowId(runningId);
            if (first) {
                runningItem.setDueDate(LocalDateTime.now().minusMinutes(1));
                runningItem.setSuccess(true);
                first = false;
            }

            RepositoryCache.getRunningWorkflowItemRepository().createWorkflowRun(runningItem);
        }
    }
}
