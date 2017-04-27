package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.adminservice.data.dto.CompanyUnit;
import wk.easyonboard.common.datatransfer.CompanyUnitDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/27/17.
 */
@Path("/company/{companyId}")
public class CompanyController {
    @Path("/units")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyUnitDTO> getCompanyUnitsForCompany(@PathParam("companyId") UUID companyId) {
        final List<CompanyUnit> companyUnits = RepositoryCache.getcompanyUnitRepository().readMany(companyId);

        return companyUnits.stream()
                .map(CompanyUnit::toServerDTO)
                .collect(Collectors.toList());
    }
}
