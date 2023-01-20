package pl.javastart.bootcamp.domain.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from UserRole u where u.user.id = :id and u.role = :role")
    void dismissRole(Long id, Role role);
}
