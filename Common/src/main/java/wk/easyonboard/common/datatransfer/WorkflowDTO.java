package wk.easyonboard.common.datatransfer;

import java.util.List;
import java.util.UUID;

/**
 * Created by david.leyendecker on 26.04.2017.
 */
public class WorkflowDTO {
    private UUID id;
    private String name;
    private List<WorkflowItemDTO> items;

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

    public List<WorkflowItemDTO> getItems() {
        return items;
    }

    public void setItems(List<WorkflowItemDTO> items) {
        this.items = items;
    }
}
