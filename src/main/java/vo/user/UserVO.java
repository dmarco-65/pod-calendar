package vo.user;

import lombok.Builder;
import lombok.Data;
import utils.RoleEnum;

import java.util.UUID;

@Data
@Builder
public class UserVO {

    private UUID uuid;

    private String password;

    private String pseudo;

    private String email;

    private Integer roleId;


    public RoleEnum getRole() {
        return RoleEnum.getById(roleId);
    }

    public void setRole(RoleEnum role) {
        this.roleId = role.getId();
    }
}
