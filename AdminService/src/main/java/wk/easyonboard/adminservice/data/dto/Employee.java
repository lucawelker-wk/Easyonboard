package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Employee {
    private UUID id;
    private String lastName;
    private String firstName;
    private Address adress;
    private EmployeeRole employeeRole;
    private String username;
    private String email;
    private UserRole userRole;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public final EmployeeDTO toServerDTO() {
        final EmployeeDTO result = new EmployeeDTO();

        result.setId(this.getId());
        result.setFirstName(this.getFirstName());
        result.setLastName(this.getLastName());
        result.setUsername(this.getUsername());
        result.setEmail(this.getEmail());
        result.setEmployeeRole(this.getEmployeeRole());
        result.setAdress(this.getAdress().toServerDTO());
        result.setUserRole(this.getUserRole());

        return result;
    }
}
