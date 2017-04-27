package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import wk.easyonboard.adminservice.data.dto.Address;
import wk.easyonboard.adminservice.data.dto.CompanyUnit;
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
 * Created by Luca Welker on 4/27/17.
 */
public class CompanyUnitRepository extends Repository<CompanyUnit> {

    public CompanyUnitRepository() {
        super(CompanyUnit.class);
    }

    @Override
    protected DbContext initializeContext() {
        List<CompanyUnit> units = new ArrayList<>();

        CompanyUnit unit = new CompanyUnit();
        unit.setId(DemoDataConstants.DEVELOPMENT_UNIT_ID);
        unit.setName("Development");
        unit.setCompanyId(DemoDataConstants.WK_COMPANY_ID);
        unit.setManager(Lists.newArrayList(getDummyManager(DemoDataConstants.MANAGER_HANS_WURST, "Wurst", "Hans", "HWurst", EmployeeRole.manager),
                getDummyManager(DemoDataConstants.MANAGER_EDWIN_DRASER, "Draser", "Edwin", "EDraser", EmployeeRole.comanager)));

        units.add(unit);

        unit = new CompanyUnit();
        unit.setId(DemoDataConstants.BUSINESSANALYST_UNIT_ID);
        unit.setName("Business Analysts");
        unit.setCompanyId(DemoDataConstants.WK_COMPANY_ID);
        unit.setManager(Lists.newArrayList(getDummyManager(DemoDataConstants.MANAGER_KATJA_REMBOLD, "Rembold", "Katja", "KRembold", EmployeeRole.manager),
                getDummyManager(DemoDataConstants.MANAGER_STEFAN_SCHATZ, "Schatz", "Stefan", "SSchatz", EmployeeRole.comanager)));

        units.add(unit);

        return new DummyContext<>(units, CompanyUnit.class);
    }

    private Employee getDummyManager(UUID id, String name, String firstName, String username, EmployeeRole role) {
        Employee emp = new Employee();
        emp.setEntersOn(LocalDate.of(2000, 01, 01));
        emp.setUserRole(UserRole.user);
        emp.setUsername(username);
        emp.setLastName(name);
        emp.setFirstName(firstName);
        emp.setId(id);
        emp.setEmployeeRole(role);
        emp.setEmail(String.format("%s.%s@easyonboard.de", firstName, name));

        Address address = new Address();
        address.setZipCode("75015");
        address.setStreet("Pforzheimerstraße 46/1");
        address.setCity("Bretten");
        address.setState("BW");
        address.setCountry("Germany");

        emp.setEmployeeAddress(address);
        return emp;
    }

    public List<CompanyUnit> readMany(UUID companyId) {
        return super.readMany(ImmutableMap.of("companyId", companyId));
    }

    public List<CompanyUnit> readAll() {
        return super.readAll();
    }

    public boolean create(CompanyUnit companyUnit) throws IllegalAccessException {
        return super.create(companyUnit);
    }
}
