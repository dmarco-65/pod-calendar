package api.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.user.UserService;
import vo.user.UserVO;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserVO>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> createUser(UserVO userVO) {
        Boolean isCreated = userService.createUser(userVO);
        if (!isCreated) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<UserVO> updateUser(UserVO userVO) {
        return ResponseEntity.ok(userService.updateUser(userVO));
    }
}
