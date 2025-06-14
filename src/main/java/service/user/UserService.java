package service.user;

import utils.RoleEnum;
import vo.user.UserVO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserVO> findAll();

    Boolean createUser(UserVO userVO);

    UserVO updateUser(UserVO userVO);

    Boolean deleteUserUuid(UUID id);

    List<UserVO> getByRoles(List<RoleEnum> roles);


}
