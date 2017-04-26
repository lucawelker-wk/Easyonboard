package wk.easyonboard.gateway;

import wk.easyonboard.common.Launchable;
import wk.easyonboard.gateway.controller.CompanyClientController;
import wk.easyonboard.gateway.controller.EmployeeClientController;
import wk.easyonboard.gateway.controller.WorkflowClientController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Gateway extends Launchable {
    @Override
    protected Set<Class<?>> provideResources() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(WorkflowClientController.class);
        resources.add(EmployeeClientController.class);
        resources.add(CompanyClientController.class);
        return resources;
    }

    @Override
    public int getPortNr() {
        return 9080;
    }
}
