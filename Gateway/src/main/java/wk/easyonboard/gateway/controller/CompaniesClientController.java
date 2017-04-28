package wk.easyonboard.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.CompanyDTO;
import wk.easyonboard.common.datatransfer.CompanyUnitDTO;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Api(value = "/api/companies", description = "Access to all companies")
@Path("/api/companies")
public class CompaniesClientController extends BaseClientController {

    @ApiOperation(value = "Gets company count", notes = "Returns the count of all companies", response = Integer.class)
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

    @ApiOperation(value = "Gets all companies", response = CompanyUnitDTO.class)
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

    @ApiOperation(value = "Creates new company", notes = "Returns the UUID for the newly created company", response = UUID.class)
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
