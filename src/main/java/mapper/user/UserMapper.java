package mapper.user;

import entity.user.User;
import mapper.EntityVOMapper;
import org.springframework.stereotype.Component;
import vo.user.UserVO;

@Component
public class UserMapper implements EntityVOMapper<User, UserVO> {

    @Override
    public UserVO toVO(User user) {
        if (user == null) return null;

        return UserVO.builder()
                .uuid(user.getUuid())
                .pseudo(user.getPseudo())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .build();
    }

    @Override
    public User toEntity(UserVO vo) {
        if (vo == null) return null;
        User user = new User();
        user.setUuid(user.getUuid());
        user.setPassword(user.getPassword());
        user.setPseudo(user.getPseudo());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        return user;
    }
}
