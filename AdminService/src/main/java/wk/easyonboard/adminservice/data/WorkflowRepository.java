package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.adminservice.data.dto.Workflow;
import wk.easyonboard.adminservice.data.dto.WorkflowItem;
import wk.easyonboard.common.dataaccess.DbContext;
import wk.easyonboard.common.dataaccess.DummyContext;
import wk.easyonboard.common.dataaccess.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class WorkflowRepository extends Repository<Workflow> {
    public WorkflowRepository() {
        super(Workflow.class);
    }

    @Override
    protected DbContext initializeContext() {
        List<Workflow> data = new ArrayList<Workflow>();

        Workflow flow = new Workflow();
        flow.setItems(new ArrayList<>());
        flow.setId(UUID.randomUUID());
        flow.setName("Test Workflow");

        for (int i = 1; i <= 10; ++i) {
            WorkflowItem item = new WorkflowItem();
            item.setId(UUID.randomUUID());
            item.setDescription("This is a test workflowitem " + i);
            item.setName("Workflow Item " + i);
            item.setType("wk.easyonboard.workflow.sendmail");
            item.setParameters(ImmutableMap.of("receiver", "test@test.de"));
            flow.getItems().add(item);
        }

        data.add(flow);
        return new DummyContext<>(data, Workflow.class);
    }

    public Workflow read(UUID workflowId) throws IllegalAccessException, InstantiationException {
        return read(ImmutableMap.of("Id", workflowId.toString()));
    }

    public List<Workflow> readAll() {
        return super.readAll();
    }
}
