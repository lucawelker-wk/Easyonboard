package wk.easyonboard.gateway.controller;

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
@Path("/api/company/unit/{companyUnitId}")
public class CompanyUnitClientController extends BaseClientController {
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
