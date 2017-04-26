package wk.easyonboard.common.datatransfer;

import java.util.List;
import java.util.UUID;

/**
 * Created by david.leyendecker on 26.04.2017.
 */
public class CompanyUnitDTO {
    private UUID id;
    private String name;
    private UUID companyId;
    private List<EmployeeDTO> manager;

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

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public List<EmployeeDTO> getManager() {
        return manager;
    }

    public void setManager(List<EmployeeDTO> manager) {
        this.manager = manager;
    }
}
