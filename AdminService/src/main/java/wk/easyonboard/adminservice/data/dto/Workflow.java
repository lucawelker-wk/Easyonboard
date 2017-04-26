package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.WorkflowDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Workflow {
    public UUID Id;
    public String Name;
    public List<WorkflowItem> Items;

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

    public List<WorkflowItem> getItems() {
        return Items;
    }

    public void setItems(List<WorkflowItem> items) {
        this.Items = items;
    }

    public final WorkflowDTO toServerDTO() {
        WorkflowDTO result = new WorkflowDTO();
        result.setId(this.getId());
        result.setName(this.getName());
        result.setItems(this.getItems().stream()
                .map(i -> i.toServerDTO()).collect(Collectors.toList()));

        return result;
    }

    public static final Workflow fromServerDTO(WorkflowDTO data) {
        Workflow workflow = new Workflow();
        workflow.setId(data.getId());
        workflow.setName(data.getName());
        workflow.setItems(data.getItems().stream()
                .map(i -> WorkflowItem.fromServerDTO(i))
                .collect(Collectors.toList()));

        return workflow;
    }
}
