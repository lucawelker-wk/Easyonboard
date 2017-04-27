package wk.easyonboard.adminservice.controller;

import wk.easyonboard.adminservice.RepositoryCache;
import wk.easyonboard.adminservice.data.dto.Company;
import wk.easyonboard.common.datatransfer.CompanyDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Luca Welker on 4/26/17.
 */
@Path("/companies")
public class CompaniesController {
    @Path("/count")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCompaniesCount() {
        return RepositoryCache.getCompanyRepository().readAll().size();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyDTO> getCompanies() {
        final List<Company> companies = RepositoryCache.getCompanyRepository().readAll();

        return companies.stream()
                .map(Company::toServerDTO)
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean createCompany(CompanyDTO data) throws IllegalAccessException {
        data.setId(UUID.randomUUID());
        return RepositoryCache.getCompanyRepository().create(Company.fromServerDTO(data));
    }


}
