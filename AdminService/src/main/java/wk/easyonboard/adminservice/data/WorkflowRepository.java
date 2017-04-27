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
        flow.setName("Developer workflow");

        flow.getItems().add(createWorkflowItem("Send Mail", "Send a mail", "wk.easyonboard.workflow.sendmail"));
        flow.getItems().add(createWorkflowItem("Create Jira-Account", "Creates a jira account", "wk.easyonboard.workflow.jiraccount"));
        flow.getItems().add(createWorkflowItem("Create LDAP-Account", "Creates a ldap account", "wk.easyonboard.workflow.ldapaccount"));
        data.add(flow);
        return new DummyContext<>(data, Workflow.class);
    }

    private WorkflowItem createWorkflowItem(String name, String description, String type) {
        WorkflowItem item = new WorkflowItem();
        item.setId(UUID.randomUUID());
        item.setDescription(description);
        item.setName(name);
        item.setType(type);
        item.setParameters(ImmutableMap.of("receiver", "test@test.de"));

        return item;
    }

    public Workflow read(UUID workflowId) throws IllegalAccessException, InstantiationException {
        return read(ImmutableMap.of("id", workflowId));
    }

    public List<Workflow> readAll() {
        return super.readAll();
    }
}
