package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.WorkflowItemDTO;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class WorkflowItem {
    public UUID Id;
    public String Name;
    public String Description;
    public String Type;
    public Map<String, String> Parameters;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public Map<String, String> getParameters() {
        return Parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.Parameters = parameters;
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

    public final static WorkflowItem fromServerDTO(WorkflowItemDTO data) {
        WorkflowItem result = new WorkflowItem();
        result.setDescription(data.getDescription());
        result.setId(data.getId());
        result.setName(data.getName());
        result.setParameters(data.getParameters());
        result.setType(data.getType());

        return result;
    }
}
