package entity.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "pseudo", nullable = false)
    private String pseudo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Transient
    public RoleEnum getRole() {
        return RoleEnum.getById(roleId);
    }

    public void setRole(RoleEnum role) {
        this.roleId = role.getId();
    }


}
