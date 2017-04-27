package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
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

        employees.addAll(Lists.newArrayList(getDummyEmployee(DemoDataConstants.MANAGER_DAVID_LEYENDECKER, LocalDate.of(2000, 1, 1), "Leyendecker", "David", "david.leyendecker", EmployeeRole.comanager,
                DemoDataConstants.DEVELOPMENT_UNIT_ID),
                getDummyEmployee(DemoDataConstants.MANAGER_EDWIN_DRASER, LocalDate.of(1999, 5, 1), "Draser", "Edwin", "edwin.draser", EmployeeRole.manager,
                        DemoDataConstants.DEVELOPMENT_UNIT_ID)));

        employees.addAll(Lists.newArrayList(getDummyEmployee(DemoDataConstants.MANAGER_KATJA_REMBOLD, LocalDate.of(2001, 6, 1), "Rembold", "Katja", "katja.rembold", EmployeeRole.manager,
                DemoDataConstants.BUSINESSANALYST_UNIT_ID),
                getDummyEmployee(DemoDataConstants.MANAGER_STEFAN_SCHATZ, LocalDate.of(1998, 1, 1), "Schatz", "Stefan", "stefan.schatz", EmployeeRole.comanager,
                        DemoDataConstants.BUSINESSANALYST_UNIT_ID)));

        employees.add(getDummyEmployee(DemoDataConstants.EMPLOYEE_KLAUS_NOTENTERED, LocalDate.of(2017, 5, 1), "Welker", "Luca",
                "luca.welker", EmployeeRole.employee, DemoDataConstants.DEVELOPMENT_UNIT_ID));

        return new DummyContext<>(employees, Employee.class);
    }

    private Employee getDummyEmployee(UUID id, LocalDate entersOn, String name, String firstName, String username, EmployeeRole role, UUID companyUnitId) {
        Employee emp = new Employee();
        emp.setEntersOn(entersOn);
        emp.setUserRole(UserRole.user);
        emp.setUsername(username);
        emp.setLastName(name);
        emp.setFirstName(firstName);
        emp.setId(id);
        emp.setEmployeeRole(role);
        emp.setEmail(String.format("%s.%s@easyonboard.de", firstName, name));
        emp.setCompanyUnitId(companyUnitId);

        Address address = new Address();
        address.setZipCode("75015");
        address.setStreet("Pforzheimerstraße 46/1");
        address.setCity("Bretten");
        address.setState("BW");
        address.setCountry("Germany");

        emp.setEmployeeAddress(address);
        return emp;
    }

    public Employee read(UUID userId) throws IllegalAccessException, InstantiationException {
        return read(ImmutableMap.of("id", userId));
    }

    public List<Employee> readAll() {
        return super.readAll();
    }
}
