package pl.javastart.bootcamp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javastart.bootcamp.domain.user.role.Role;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByActivationCode(String activationCode);

    Optional<User> findByAuthKey(String authKey);

    List<User> findByActivated(boolean isActivated);

    Optional<User> findByPasswordResetKey(String key);

    @Query(value = "SELECT u as user, COALESCE(r.role, 'ROLE_USER') as role " +
            "FROM User u left outer join u.roles r")
    List<UserWithAdminRole> getAllUsersWithRole(Role role);

}
