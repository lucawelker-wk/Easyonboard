package wk.easyonboard.adminservice.data.dto;

import wk.easyonboard.common.datatransfer.EmployeeDTO;
import wk.easyonboard.common.datatransfer.EmployeeRole;
import wk.easyonboard.common.datatransfer.UserRole;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class Employee {
    public UUID Id;
    public UUID companyUnitId;
    public String lastName;
    public String firstName;
    public Address employeeAddress;
    public EmployeeRole employeeRole;
    public String Username;
    public String email;
    public UserRole userRole;
    public LocalDate entersOn;
    public LocalDate leavesOn;
    public String avatarUrl;
    public UUID mentorId;

    public LocalDate getEntersOn() {
        return entersOn;
    }

    public void setEntersOn(LocalDate entersOn) {
        this.entersOn = entersOn;
    }

    public LocalDate getLeavesOn() {
        return leavesOn;
    }

    public void setLeavesOn(LocalDate leavesOn) {
        this.leavesOn = leavesOn;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        this.Id = id;
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

    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
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

    public UUID getMentorId() {
        return mentorId;
    }

    public void setMentorId(UUID mentorId) {
        this.mentorId = mentorId;
    }

    public UUID getCompanyUnitId() {
        return companyUnitId;
    }

    public void setCompanyUnitId(UUID companyUnitId) {
        this.companyUnitId = companyUnitId;
    }

    public static final Employee fromServerDTO(EmployeeDTO data) {
        final Employee employee = new Employee();
        employee.setEmployeeAddress(Address.fromServerDTO(data.getAdress()));
        employee.setEmail(data.getEmail());
        employee.setEmployeeRole(data.getEmployeeRole());
        employee.setFirstName(data.getFirstName());
        employee.setId(data.getId());
        employee.setLastName(data.getLastName());
        employee.setUsername(data.getUsername());
        employee.setUserRole(data.getUserRole());
        employee.setLeavesOn(data.getLeavesOn());
        employee.setEntersOn(data.getEntersOn());
        employee.setAvatarUrl(data.getAvatarUrl());
        employee.setMentorId(data.getMentorId());
        employee.setCompanyUnitId(data.getCompanyUnitId());

        return employee;
    }

    public final EmployeeDTO toServerDTO() {
        final EmployeeDTO result = new EmployeeDTO();

        result.setId(this.getId());
        result.setFirstName(this.getFirstName());
        result.setLastName(this.getLastName());
        result.setUsername(this.getUsername());
        result.setEmail(this.getEmail());
        result.setEmployeeRole(this.getEmployeeRole());
        result.setAdress(this.getEmployeeAddress().toServerDTO());
        result.setUserRole(this.getUserRole());
        result.setLeavesOn(this.getLeavesOn());
        result.setEntersOn(this.getEntersOn());
        result.setAvatarUrl(this.getAvatarUrl());
        result.setMentorId(this.getMentorId());
        result.setCompanyUnitId(this.getCompanyUnitId());

        return result;
    }
}
