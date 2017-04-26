package wk.easyonboard.adminservice;

import wk.easyonboard.adminservice.controller.EmployeeController;
import wk.easyonboard.adminservice.controller.WorkflowController;
import wk.easyonboard.common.Launchable;
import wk.easyonboard.common.ServiceConstants;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class AdminService extends Launchable {
    protected Set<Class<?>> provideResources() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(EmployeeController.class);
        resources.add(WorkflowController.class);

        return resources;
    }

    public int getPortNr() {
        return ServiceConstants.ADMINSERVICE_PORT;
    }
}
