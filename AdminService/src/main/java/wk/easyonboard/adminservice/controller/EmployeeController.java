package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.data.EmployeeRepository;
import wk.easyonboard.adminservice.data.dto.Employee;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by luca.welker on 4/26/17.
 */
@Path("/employees")
public class EmployeeController {
    private EmployeeRepository repository;

    public EmployeeController() {
        repository = new EmployeeRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDTO> getEmployees() {
        final List<Employee> employees = repository.readAll();

        return employees.stream()
                .map(x -> x.toServerDTO()).collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createEmployee(EmployeeDTO employee) throws IllegalAccessException {
        return repository.create(Employee.fromServerDTO(employee));
    }
}
