package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.adminservice.data.dto.Address;
import wk.easyonboard.adminservice.data.dto.Employee;
import wk.easyonboard.common.dataaccess.DbContext;
import wk.easyonboard.common.dataaccess.DummyContext;
import wk.easyonboard.common.dataaccess.Repository;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by luca.welker on 4/26/17.
 */
public class EmployeeRepository extends Repository<Employee> {

    public EmployeeRepository() {
        super(Employee.class);
    }

    @Override
    protected DbContext initializeContext() {
        List<Employee> employees = new ArrayList<Employee>();

        Address address = new Address();
        address.setCity("Bretten");
        address.setCountry("Germany");
        address.setState("BW");
        address.setStreet("Pforzheimerstraße 46/1");
        address.setZipCode("75015");

        for (int i = 1; i <= 10; ++i) {
            final Employee employee = new Employee();
            employee.setId(UUID.randomUUID());
            employee.setFirstName("Firstname " + i);
            employee.setLastName("Lastname " + i);
            employee.setUsername("Username " + i);
            employee.setEmail(String.format("user%s@easyonboard.de", i));
            employee.setEmployeeRole(EmployeeRole.employee);
            employee.setAddress(address);
            employee.setUserRole(UserRole.user);

            employees.add(employee);
        }

        Employee manager = new Employee();
        manager.setId(UUID.randomUUID());
        manager.setFirstName("Hans");
        manager.setLastName("Manager");
        manager.setUsername("hans.manager");
        manager.setEmail(String.format("klaus.manager@easyonboard.de"));
        manager.setEmployeeRole(EmployeeRole.employee);
        manager.setAddress(address);
        manager.setUserRole(UserRole.admin);
        employees.add(manager);

        return new DummyContext<>(employees, Employee.class);
    }

    public Employee read(UUID userId) {
        return read(ImmutableMap.of("Id", userId.toString()));
    }

    public List<Employee> readAll() {
        return super.readAll();
    }
}
