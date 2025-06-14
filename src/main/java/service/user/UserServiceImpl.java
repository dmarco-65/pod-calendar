package service.user;

import entity.user.User;
import jakarta.transaction.Transactional;
import mapper.user.UserMapper;
import repository.UserRepository;
import utils.RoleEnum;
import vo.user.UserVO;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserVO> findAll() {
        return userMapper.toVOList(
                this.userRepository.findAll());
    }

    @Override
    @Transactional
    public Boolean createUser(UserVO userVO) {
        this.userRepository.save(userMapper.toEntity(userVO));
        return this.userRepository.existsByPseudo(userVO.getPseudo());
    }

    @Override
    public UserVO updateUser(UserVO userVO) {
        User user = this.userRepository.save(userMapper.toEntity(userVO));
        return userMapper.toVO(user);
    }

    @Override
    public Boolean deleteUserUuid(UUID id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null) return false;
        this.userRepository.delete(user);
        return this.userRepository.existsById(id);
    }

    @Override
    public List<UserVO> getByRoles(List<RoleEnum> roles) {
//        List<int[]> rolesIds = roles.stream().map(RoleEnum::getId).map(id -> new int[]{id}).toList();
//        List<User> users = this.userRepository.findByRoleIdContaining(rolesIds);
        return userMapper.toVOList(null);
    }
}
