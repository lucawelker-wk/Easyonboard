package wk.easyonboard.common.datatransfer;

import java.util.Map;
import java.util.UUID;

/**
 * Created by david.leyendecker on 26.04.2017.
 */
public class WorkflowItemDTO {
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
}