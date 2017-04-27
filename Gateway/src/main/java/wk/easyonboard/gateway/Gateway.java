package wk.easyonboard.gateway;

import wk.easyonboard.common.Launchable;
import wk.easyonboard.gateway.controller.*;
import wk.easyonboard.common.ServiceConstants;

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
        resources.add(EmployeesClientController.class);
        resources.add(CompaniesClientController.class);
        resources.add(CompanyClientController.class);
        resources.add(WorkflowClientController.class);
        resources.add(CompanyUnitClientController.class);
        resources.add(EmployeeClientController.class);
        return resources;
    }

    @Override
    public int getPortNr() {
        return ServiceConstants.GATEWAY_PORT;
    }
}
