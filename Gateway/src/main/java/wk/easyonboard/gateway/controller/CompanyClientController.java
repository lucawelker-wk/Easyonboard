package wk.easyonboard.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.CompanyUnitDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Api(value = "/api/company/{companyId}", description = "Access to companies")
@Path("/api/company/{companyId}")
public class CompanyClientController extends BaseClientController {

    @ApiOperation(value = "Get all company units", notes = "Returns all company units for {companyId}", response = CompanyUnitDTO.class)
    @Path("/units")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyUnitDTO> getCompanyUnits(@PathParam("companyId") UUID companyId) {
        return buildAdminClient()
                .path("company")
                .path(companyId.toString())
                .path("units")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(new GenericType<List<CompanyUnitDTO>>() {
                });
    }

    @ApiOperation(value = "Gets companyunit count", notes = "Returns count of all company units for {companyId}", response = Integer.class)
    @Path("/units/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCompanyUnitsCount(@PathParam("companyId") UUID companyId) {
        return buildAdminClient()
                .path("company")
                .path(companyId.toString())
                .path("units")
                .path("count")
                .request(MediaType.TEXT_PLAIN)
                .buildGet()
                .invoke(Integer.class);
    }
}
