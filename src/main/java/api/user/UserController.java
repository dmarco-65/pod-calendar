package api.user;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;
import vo.user.UserVO;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Controller", description = "API pour la gestion des utilisateurs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Récupérer tous les utilisateurs")
    @GetMapping
    public ResponseEntity<List<UserVO>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Operation(summary = "Créer un nouvel utilisateur")
    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> createUser(@RequestBody @Parameter(description = "user") UserVO userVO) {
        Boolean isCreated = userService.createUser(userVO);
        if (!isCreated) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(null);
    }

    @Operation(summary = "Mettre à jour un utilisateur")
    @PostMapping(value = "/update")
    public ResponseEntity<UserVO> updateUser(@RequestBody @Parameter(description = "user") UserVO userVO) {
        return ResponseEntity.ok(userService.updateUser(userVO));
    }

    @Operation(summary = "Test de l'API")
    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"API is working\", \"timestamp\": \"" + java.time.LocalDateTime.now() + "\"}");

    }
}
