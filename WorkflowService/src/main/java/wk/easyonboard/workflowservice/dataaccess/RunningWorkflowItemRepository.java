package wk.easyonboard.workflowservice.dataaccess;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.common.dataaccess.DbContext;
import wk.easyonboard.common.dataaccess.DummyContext;
import wk.easyonboard.common.dataaccess.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class RunningWorkflowItemRepository extends Repository<RunningWorkflowItem> {
    public RunningWorkflowItemRepository() {
        super(RunningWorkflowItem.class);
    }

    @Override
    protected DbContext initializeContext() {
        return new DummyContext<>(new ArrayList<RunningWorkflowItemRepository>(), RunningWorkflowItemRepository.class);
    }

    public List<RunningWorkflowItem> readAll() {
        return super.readAll();
    }

    public RunningWorkflowItem read(UUID runningWorkflowId) throws IllegalAccessException, InstantiationException {
        return super.read(ImmutableMap.of("id", runningWorkflowId));
    }

    public List<RunningWorkflowItem> getWorkflowItems(UUID runningWorkflowId) {
        return super.readMany(ImmutableMap.of("runningWorkflowId", runningWorkflowId));
    }

    public UUID createWorkflowRun(RunningWorkflowItem workflow) throws IllegalAccessException {
        workflow.setId(UUID.randomUUID());
        super.create(workflow);
        return workflow.getId();
    }
}
