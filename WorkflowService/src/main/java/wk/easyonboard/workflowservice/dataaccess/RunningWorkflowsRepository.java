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
public class RunningWorkflowsRepository extends Repository<RunningWorkflow> {
    public RunningWorkflowsRepository() {
        super(RunningWorkflow.class);
    }

    @Override
    protected DbContext initializeContext() {
        return new DummyContext<>(new ArrayList<RunningWorkflow>(), RunningWorkflow.class);
    }

    public List<RunningWorkflow> readAll() {
        return super.readAll();
    }

    public RunningWorkflow read(UUID workflowRunnerId) throws IllegalAccessException, InstantiationException {
        return super.read(ImmutableMap.of("id", workflowRunnerId));
    }

    public List<RunningWorkflow> getWorkflowsForEmployee(UUID employeeId) {
        return super.readMany(ImmutableMap.of("employeeId", employeeId));
    }

    public UUID createWorkflowRun(RunningWorkflow workflow) throws IllegalAccessException {
        workflow.setId(UUID.randomUUID());
        super.create(workflow);
        return workflow.getId();
    }
}
