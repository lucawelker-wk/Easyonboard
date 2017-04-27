package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.adminservice.data.dto.Employee;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by luca.welker on 4/26/17.
 */
@Path("/employees")
public class EmployeeController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDTO> getEmployees() {
        final List<Employee> employees = RepositoryCache.getEmployeeRepository().readAll();

        return employees.stream()
                .map(x -> x.toServerDTO()).collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createEmployee(EmployeeDTO employee) throws IllegalAccessException {
        employee.setId(UUID.randomUUID());
        RepositoryCache.getEmployeeRepository().create(Employee.fromServerDTO(employee));
        return employee.getId();
    }

    @Path("/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getEmployeeCount() {
        return RepositoryCache.getEmployeeRepository().readAll().size();
    }
}
