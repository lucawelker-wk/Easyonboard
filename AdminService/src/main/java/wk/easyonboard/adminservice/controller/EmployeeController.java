package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Path("employee/{employeeId}")
public class EmployeeController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDTO getEmployee(@PathParam("employeeId") UUID employeeId) throws InstantiationException, IllegalAccessException {
        return RepositoryCache.getEmployeeRepository().read(employeeId).toServerDTO();
    }
}
