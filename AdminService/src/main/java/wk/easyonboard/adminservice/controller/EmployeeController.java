package wk.easyonboard.adminservice.controller;

import wk.easyonboard.common.datatransfer.AdressDTO;
import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.EmployeeRole;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wkss on 4/26/17.
 */
@Path("/employees")
public class EmployeeController {
    @GET
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
        for (int i = 1; i <= 10; ++i) {
            final EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(UUID.randomUUID());
            employeeDTO.setFirstName("Firstname " + i);
            employeeDTO.setLastName("Lastname " + i);
            employeeDTO.setUsername("Username " + i);
            employeeDTO.setEmail(String.format("user%s@easyonboard.de", i));
            employeeDTO.setEmployeeRole(EmployeeRole.employee);

            AdressDTO address = new AdressDTO();
            address.setCity("Bretten");
            address.setCountry("Germany");
            address.setState("BW");
            address.setStreet("Pforzheimerstraße 46/1");
            address.setZipCode("75015");
            employeeDTO.setAdress(address);

            employees.add(employeeDTO);
        }

        return employees;
    }
}
