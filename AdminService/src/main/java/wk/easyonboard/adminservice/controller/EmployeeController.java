package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.data.EmployeeRepository;
import wk.easyonboard.adminservice.data.dto.Employee;
import wk.easyonboard.common.datatransfer.AdressDTO;
import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by luca.welker on 4/26/17.
 */
@Path("/employees")
public class EmployeeController {
    @GET
    public List<EmployeeDTO> getEmployees() {
        final List<Employee> employees = new EmployeeRepository().readAll();

        return employees.stream()
                .map(x -> x.toServerDTO()).collect(Collectors.toList());
    }
}
