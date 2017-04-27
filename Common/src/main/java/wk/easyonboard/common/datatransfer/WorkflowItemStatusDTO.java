package wk.easyonboard.common.datatransfer;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class WorkflowItemStatusDTO {
    private UUID runningWorkflowId;
    private UUID workflowItemId;
    private LocalDateTime dueDate;
    private boolean success;

    public UUID getRunningWorkflowId() {
        return runningWorkflowId;
    }

    public void setRunningWorkflowId(UUID runningWorkflowId) {
        this.runningWorkflowId = runningWorkflowId;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
