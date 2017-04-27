package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.CompanyUnitDTO;

import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class CompanyUnit {
    public UUID id;
    public String name;
    public UUID companyId;
    public List<UUID> manager;

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UUID> getManager() {
        return manager;
    }

    public void setManager(List<UUID> manager) {
        this.manager = manager;
    }

    public static final CompanyUnit fromServerDTO(CompanyUnitDTO data) {
        CompanyUnit result = new CompanyUnit();
        result.setId(data.getId());
        result.setManager(data.getManager());
        result.setName(data.getName());
        result.setCompanyId(data.getCompanyId());

        return result;
    }

    public final CompanyUnitDTO toServerDTO() {
        CompanyUnitDTO result = new CompanyUnitDTO();
        result.setId(this.getId());
        result.setManager(this.getManager());
        result.setName(this.getName());
        result.setCompanyId(this.getCompanyId());

        return result;
    }
}