package repository;

import entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Vérifie si un utilisateur existe avec ce nom d'utilisateur
     *
     * @param pseudo le nom d'utilisateur à vérifier
     * @return true si le nom d'utilisateur existe déjà
     */
    boolean existsByPseudo(String pseudo);

}