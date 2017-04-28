package wk.easyonboard.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wk.easyonboard.common.BaseClientController;
import wk.easyonboard.common.datatransfer.CompanyUnitDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Api(value="/api/company/unit/{companyUnitId", description = "Access to a company unit")
@Path("/api/company/unit/{companyUnitId}")
public class CompanyUnitClientController extends BaseClientController {

    @ApiOperation(value = "Gets a company unit", notes = "Gets the requested company unit with {companyUnitId}", response = CompanyUnitDTO.class)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyUnitDTO getCompanyUnit(@PathParam("companyUnitId")UUID companyUnitId) {
        return buildAdminClient()
                .path("company")
                .path("unit")
                .path(companyUnitId.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildGet()
                .invoke(CompanyUnitDTO.class);
    }
}
