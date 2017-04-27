package wk.easyonboard.adminservice.controller;

import com.google.common.collect.ImmutableMap;
import wk.easyonboard.adminservice.RepositoryCache;
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
@Path("/company/unit/{companyUnitId}")
public class CompanyUnitController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyUnitDTO getCompanyUnit(@PathParam("companyUnitId") UUID companyUnitId) throws IllegalAccessException, InstantiationException {
        return RepositoryCache.getcompanyUnitRepository().read(ImmutableMap.of("id", companyUnitId)).toServerDTO();
    }
}
