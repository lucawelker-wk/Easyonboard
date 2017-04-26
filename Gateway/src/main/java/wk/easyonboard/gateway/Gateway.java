package wk.easyonboard.gateway;

import wk.easyonboard.common.Launchable;
import wk.easyonboard.common.ServiceConstants;
import wk.easyonboard.gateway.controller.CompanyClientController;
import wk.easyonboard.gateway.controller.EmployeeClientController;
import wk.easyonboard.gateway.controller.WorkflowClientController;
import wk.easyonboard.gateway.controller.WorkflowsClientController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Gateway extends Launchable {
    @Override
    protected Set<Class<?>> provideResources() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(WorkflowsClientController.class);
        resources.add(EmployeeClientController.class);
        resources.add(CompanyClientController.class);
        resources.add(WorkflowClientController.class);
        return resources;
    }

    @Override
    public int getPortNr() {
        return ServiceConstants.GATEWAY_PORT;
    }
}
