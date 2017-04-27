package wk.easyonboard.gateway.controller;

import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.CompanyDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/api/companies")
public class CompaniesClientController extends BaseClientController {
    @Path("/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCompaniesCount() {
        final Integer invoke = buildAdminClient()
                .path("companies")
                .path("count")
                .request(MediaType.TEXT_PLAIN)
                .buildGet()
                .invoke(Integer.class);

        return invoke;
    }

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
    public UUID createCompany(CompanyDTO company) {
        return buildAdminClient()
                .path("companies")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(Entity.entity(company, MediaType.APPLICATION_JSON_TYPE))
                .invoke(UUID.class);
    }
}
