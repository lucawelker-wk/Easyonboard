package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.CompanyDTO;

import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Company {
    public UUID id;
    public String name;
    public Address adress;
    public String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public static final Company fromServerDTO(CompanyDTO data) {
        final Company company = new Company();
        company.setAdress(Address.fromServerDTO(data.getAdress()));
        company.setId(data.getId());
        company.setName(data.getName());
        company.setAvatarUrl(data.getAvatarUrl());

        return company;
    }

    public final CompanyDTO toServerDTO() {
        final CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(this.getId());
        companyDTO.setAdress(this.getAdress().toServerDTO());
        companyDTO.setName(this.getName());
        companyDTO.setAvatarUrl(this.getAvatarUrl());

        return companyDTO;
    }
}
