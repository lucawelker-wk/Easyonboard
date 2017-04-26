package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.CompanyUnitDTO;
import wk.easyonboard.common.datatransfer.EmployeeDTO;

import java.util.List;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class CompanyUnit {
    public UUID id;
    public String name;
    public List<EmployeeDTO> manager;

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

    public List<EmployeeDTO> getManager() {
        return manager;
    }

    public void setManager(List<EmployeeDTO> manager) {
        this.manager = manager;
    }

    public static final CompanyUnit fromServerDTO(CompanyUnitDTO data) {
        CompanyUnit result = new CompanyUnit();
        result.setId(data.getId());
        result.setManager(data.getManager());
        result.setName(data.getName());

        return result;
    }

    public final CompanyUnitDTO toServerDTO() {
        CompanyUnitDTO result = new CompanyUnitDTO();
        result.setId(this.getId());
        result.setManager(this.getManager());
        result.setName(this.getName());

        return result;
    }
}