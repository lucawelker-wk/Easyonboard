package wk.easyonboard.workflowservice.dataaccess;

/**
 * Created by Luca Welker on 4/27/17.
 */
public class RepositoryCache {
    private static RunningWorkflowsRepository runningWorkflowsRepository;

    public static RunningWorkflowsRepository getRunningWorkflowsRepository() {
        if (runningWorkflowsRepository == null)
            runningWorkflowsRepository = new RunningWorkflowsRepository();
        return runningWorkflowsRepository;
    }

    private static RunningWorkflowItemRepository runningWorkflowItemRepository;

    public static RunningWorkflowItemRepository getRunningWorkflowItemRepository() {
        if (runningWorkflowItemRepository == null)
            runningWorkflowItemRepository = new RunningWorkflowItemRepository();
        return runningWorkflowItemRepository;
    }
}
