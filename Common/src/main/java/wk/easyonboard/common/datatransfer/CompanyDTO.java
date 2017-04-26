package wk.easyonboard.common.datatransfer;

import java.util.UUID;

/**
 * Created by david.leyendecker on 26.04.2017.
 */
public class CompanyDTO {
    private UUID id;
    private String name;
    private AdressDTO adress;
    private String avatarUrl;

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

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
        this.adress = adress;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
