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
}
