package wk.easyonboard.common.datatransfer;

import com.owlike.genson.annotation.JsonProperty;
import wk.easyonboard.common.typadapter.LocaleDateXmlTypeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by david.leyendecker on 26.04.2017.
 */
public class EmployeeDTO {
    private UUID id;
    private UUID companyUnitId;
    private String lastName;
    private String firstName;
    private AdressDTO adress;
    private EmployeeRole employeeRole;
    private String username;
    private String email;
    private UserRole userRole;
    @JsonProperty
    @XmlJavaTypeAdapter(LocaleDateXmlTypeAdapter.class)
    private LocalDate entersOn;
    @JsonProperty
    @XmlJavaTypeAdapter(LocaleDateXmlTypeAdapter.class)
    private LocalDate leavesOn;
    private String avatarUrl;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCompanyUnitId() {
        return companyUnitId;
    }

    public void setCompanyUnitId(UUID companyUnitId) {
        this.companyUnitId = companyUnitId;
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

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
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
}

