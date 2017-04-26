package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Employee {
    public UUID Id;
    public String LastName;
    public String FirstName;
    public Address Address;
    public EmployeeRole EmployeeRole;
    public String Username;
    public String Email;
    public UserRole UserRole;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        this.Id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public EmployeeRole getEmployeeRole() {
        return EmployeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.EmployeeRole = employeeRole;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        this.Address = address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public UserRole getUserRole() {
        return UserRole;
    }

    public void setUserRole(UserRole userRole) {
        this.UserRole = userRole;
    }

    public final EmployeeDTO toServerDTO() {
        final EmployeeDTO result = new EmployeeDTO();

        result.setId(this.getId());
        result.setFirstName(this.getFirstName());
        result.setLastName(this.getLastName());
        result.setUsername(this.getUsername());
        result.setEmail(this.getEmail());
        result.setEmployeeRole(this.getEmployeeRole());
        result.setAdress(this.getAddress().toServerDTO());
        result.setUserRole(this.getUserRole());

        return result;
    }
}
