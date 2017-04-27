package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.adminservice.data.dto.Address;
import wk.easyonboard.adminservice.data.dto.Employee;
import wk.easyonboard.common.dataaccess.DbContext;
import wk.easyonboard.common.dataaccess.DummyContext;
import wk.easyonboard.common.dataaccess.Repository;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import java.time.LocalDate;
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
            employee.setEmployeeAddress(address);
            employee.setUserRole(UserRole.user);
            employee.setEntersOn(LocalDate.now().minusYears(5 * i));
            employee.setLeavesOn(LocalDate.now().plusYears(i * 10));
            employee.setCompanyUnitId(i % 2 == 0 ? DemoDataConstants.BUSINESSANALYST_UNIT_ID : DemoDataConstants.DEVELOPMENT_UNIT_ID);
            employee.setMentorId(i % 2 == 0 ? i % 2 != 0 ? DemoDataConstants.MANAGER_KATJA_REMBOLD : DemoDataConstants.MANAGER_STEFAN_SCHATZ :
                    i % 2 != 0 ? DemoDataConstants.MANAGER_HANS_WURST : DemoDataConstants.MANAGER_EDWIN_DRASER);

            employees.add(employee);
        }

        Employee notEnteredYet = new Employee();
        notEnteredYet.setId(UUID.randomUUID());
        notEnteredYet.setFirstName("Klaus");
        notEnteredYet.setLastName("NotEntered");
        notEnteredYet.setUsername("klaus.notentered");
        notEnteredYet.setEmail(String.format("klaus.notentered@easyonboard.de"));
        notEnteredYet.setEmployeeRole(EmployeeRole.employee);
        notEnteredYet.setEmployeeAddress(address);
        notEnteredYet.setUserRole(UserRole.user);
        notEnteredYet.setEntersOn(LocalDate.of(2017, 05, 01));
        notEnteredYet.setCompanyUnitId(DemoDataConstants.DEVELOPMENT_UNIT_ID);
        employees.add(notEnteredYet);

        return new DummyContext<>(employees, Employee.class);
    }

    public Employee read(UUID userId) throws IllegalAccessException, InstantiationException {
        return read(ImmutableMap.of("id", userId));
    }

    public List<Employee> readAll() {
        return super.readAll();
    }
}
