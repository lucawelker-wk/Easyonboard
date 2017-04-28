package wk.easyonboard.workflowservice.dataaccess;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class RunningWorkflowItem {
    public UUID id;
    public UUID runningWorkflowId;
    public UUID workflowId;
    public UUID workflowItemId;
    public LocalDateTime dueDate;
    public boolean success;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRunningWorkflowId() {
        return runningWorkflowId;
    }

    public void setRunningWorkflowId(UUID runningWorkflowId) {
        this.runningWorkflowId = runningWorkflowId;
    }

    public UUID getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(UUID workflowId) {
        this.workflowId = workflowId;
    }

    public UUID getWorkflowItemId() {
        return workflowItemId;
    }

    public void setWorkflowItemId(UUID workflowItemId) {
        this.workflowItemId = workflowItemId;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
