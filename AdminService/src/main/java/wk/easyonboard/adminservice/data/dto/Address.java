package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.AdressDTO;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Address {
    public String Street;
    public String ZipCode;
    public String City;
    public String State;
    public String Country;

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        this.ZipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public static final Address fromServerDTO(AdressDTO address) {
        final Address tmp = new Address();
        tmp.setCity(address.getCity());
        tmp.setCountry(address.getCountry());
        tmp.setState(address.getState());
        tmp.setStreet(address.getStreet());
        tmp.setZipCode(address.getZipCode());

        return tmp;
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
