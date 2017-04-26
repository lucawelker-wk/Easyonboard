package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.WorkflowItemDTO;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class WorkflowItem {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private Map<String, String> parameters;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public final WorkflowItemDTO toServerDTO() {
        WorkflowItemDTO result = new WorkflowItemDTO();
        result.setDescription(this.getDescription());
        result.setId(this.getId());
        result.setName(this.getName());
        result.setParameters(this.getParameters());
        result.setType(this.getType());

        return result;
    }
}
