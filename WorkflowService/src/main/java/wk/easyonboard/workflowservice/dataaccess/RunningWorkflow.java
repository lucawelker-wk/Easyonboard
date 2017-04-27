package wk.easyonboard.workflowservice.dataaccess;

import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class RunningWorkflow {
    public UUID id;
    public UUID workflowId;
    public UUID employeeId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(UUID workflowId) {
        this.workflowId = workflowId;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }
}
