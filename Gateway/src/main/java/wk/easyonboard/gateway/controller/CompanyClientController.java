package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.datatransfer.CompanyDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/companies")
public class CompanyClientController extends BaseClientController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyDTO> getCompanies() {
        return buildAdminClient()
                .path("companies")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<CompanyDTO>>() {
                });
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean createCompany(CompanyDTO company) {
        Response response = buildAdminClient()
                .path("companies")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.entity(company, MediaType.APPLICATION_JSON_TYPE))
                .invoke();

        return response.getStatusInfo().getStatusCode() == 200;
    }
}
