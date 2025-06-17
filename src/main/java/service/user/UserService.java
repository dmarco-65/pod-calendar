package service.user;

import vo.user.UserVO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserVO> findAll();

    Boolean createUser(UserVO userVO);

    UserVO updateUser(UserVO userVO);

    Boolean deleteUserUuid(UUID id);


}
