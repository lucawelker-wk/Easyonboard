package wk.easyonboard.adminservice;

import wk.easyonboard.adminservice.data.CompanyRepository;
import wk.easyonboard.adminservice.data.CompanyUnitRepository;
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

    private static CompanyRepository companyRepository;

    public static CompanyRepository getCompanyRepository() {
        if (companyRepository == null)
            companyRepository = new CompanyRepository();
        return companyRepository;
    }

    private static CompanyUnitRepository companyUnitRepository;

    public static CompanyUnitRepository getcompanyUnitRepository() {
        if (companyUnitRepository == null)
            companyUnitRepository = new CompanyUnitRepository();
        return companyUnitRepository;
    }
}
