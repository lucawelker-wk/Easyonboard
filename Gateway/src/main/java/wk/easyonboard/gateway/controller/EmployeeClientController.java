package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.BaseClientController;
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
@Path("/api/employee/{employeeId}")
public class EmployeeClientController extends BaseClientController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDTO getEmployee(@PathParam("employeeId") UUID employeeId) {
        return buildAdminClient()
                .path("employee")
                .path(employeeId.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(EmployeeDTO.class);
    }
}
