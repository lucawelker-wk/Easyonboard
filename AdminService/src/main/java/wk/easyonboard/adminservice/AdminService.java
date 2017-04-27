package wk.easyonboard.adminservice;

import wk.easyonboard.adminservice.controller.*;
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
        resources.add(EmployeesController.class);
        resources.add(WorkflowsController.class);
        resources.add(CompaniesController.class);
        resources.add(CompanyController.class);
        resources.add(CompanyUnitController.class);
        resources.add(EmployeeController.class);
        resources.add(WorkflowController.class);
        return resources;
    }

    public int getPortNr() {
        return ServiceConstants.ADMINSERVICE_PORT;
    }
}
