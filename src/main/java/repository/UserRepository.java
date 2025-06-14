package repository;

import entity.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Recherche un utilisateur par son nom d'utilisateur
     *
     * @param username le nom d'utilisateur
     * @return Optional contenant l'utilisateur s'il existe
     */
    Optional<User> findByUsername(String username);

    /**
     * Recherche un utilisateur par son email
     *
     * @param email l'adresse email
     * @return Optional contenant l'utilisateur s'il existe
     */
    Optional<User> findByEmail(String email);

    /**
     * Vérifie si un utilisateur existe avec cet email
     *
     * @param email l'adresse email à vérifier
     * @return true si l'email existe déjà
     */
    boolean existsByEmail(String email);

    /**
     * Vérifie si un utilisateur existe avec ce nom d'utilisateur
     *
     * @param pseudo le nom d'utilisateur à vérifier
     * @return true si le nom d'utilisateur existe déjà
     */
    boolean existsByPseudo(String pseudo);

    /**
     * Finds and retrieves a list of users assigned to the specified roles.
     *
     * @param roles the list of roles to search for associated users
     * @return a list of users that are associated with the provided roles
     */
    List<User> findByRoles(List<Role> roles);


    /**
     * Updates an existing user in the repository.
     *
     * @param user the User object containing updated user details
     * @return the updated User object
     */
    User updateUser(User user);

    List<User> findByRoleIdContaining(Integer roleId, Sort sort);
}