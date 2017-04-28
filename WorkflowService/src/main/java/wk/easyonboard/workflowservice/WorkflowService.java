package wk.easyonboard.workflowservice;

import wk.easyonboard.common.Launchable;
import wk.easyonboard.common.ServiceConstants;
import wk.easyonboard.workflowservice.controller.EmployeeController;
import wk.easyonboard.workflowservice.controller.WorkflowController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class WorkflowService extends Launchable {
    @Override
    protected Set<Class<?>> provideResources() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(WorkflowController.class);
        resources.add(EmployeeController.class);
        return resources;
    }

    @Override
    public int getPortNr() {
        return ServiceConstants.WORKFLOWSERVICE_PORT;
    }
}
