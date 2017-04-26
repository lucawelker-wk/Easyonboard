package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.AdressDTO;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Address {
    private String street;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public final AdressDTO toServerDTO() {
        AdressDTO address = new AdressDTO();
        address.setCity(this.getCity());
        address.setCountry(this.getCountry());
        address.setState(this.getState());
        address.setStreet(this.getStreet());
        address.setZipCode(this.getZipCode());

        return address;
    }
}
