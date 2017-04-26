package wk.easyonboard.adminservice;

import wk.easyonboard.adminservice.data.EmployeeRepository;
import wk.easyonboard.adminservice.data.WorkflowRepository;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class RepositoryCache {
    private static EmployeeRepository employeeRepository;

    public static EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null)
            employeeRepository = new EmployeeRepository();
        return employeeRepository;
    }

    private static WorkflowRepository workflowRepository;

    public static WorkflowRepository getWorkflowRepository() {
        if (workflowRepository == null)
            workflowRepository = new WorkflowRepository();
        return workflowRepository;
    }
}
