package wk.easyonboard.common.datatransfer;

import com.owlike.genson.annotation.JsonProperty;
import wk.easyonboard.common.typadapter.LocaleDateTimeXmlTypeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class WorkflowItemStatusDTO {
    public UUID runningWorkflowId;
    public UUID workflowItemId;
    @JsonProperty
    @XmlJavaTypeAdapter(LocaleDateTimeXmlTypeAdapter.class)
    public LocalDateTime dueDate;
    public boolean success;

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
