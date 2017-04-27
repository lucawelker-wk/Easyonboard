package wk.easyonboard.workflowservice.services;

import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.WorkflowDTO;

import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class AdminService extends BaseClientController {
    public WorkflowDTO getWorkflow(UUID workflowId) {
        return buildAdminClient()
                .path("workflow")
                .path(workflowId.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(WorkflowDTO.class);
    }
}
