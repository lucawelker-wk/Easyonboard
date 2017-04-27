package wk.easyonboard.adminservice.data;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import wk.easyonboard.adminservice.data.dto.Address;
import wk.easyonboard.adminservice.data.dto.Company;
import wk.easyonboard.common.dataaccess.DbContext;
import wk.easyonboard.common.dataaccess.DummyContext;
import wk.easyonboard.common.dataaccess.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class CompanyRepository extends Repository<Company> {

    public CompanyRepository() {
        super(Company.class);
    }

    @Override
    protected DbContext initializeContext() {
        Address address = new Address();
        address.setZipCode("75015");
        address.setStreet("Pforzheimerstraße 46/1");
        address.setCity("Bretten");
        address.setState("BW");
        address.setCountry("Germany");

        Company company = new Company();
        company.setName("Wolters Kluwer");
        company.setId(DemoDataConstants.WK_COMPANY_ID);
        company.setAdress(address);

        return new DummyContext<>(Lists.newArrayList(company), Company.class);
    }

    public List<Company> readAll() {
        return super.readAll();
    }

    public Company read(UUID id) throws IllegalAccessException, InstantiationException {
        return super.read(ImmutableMap.of("Id", id));
    }

    public boolean create(Company data) throws IllegalAccessException {
        return super.create(data);
    }
}
