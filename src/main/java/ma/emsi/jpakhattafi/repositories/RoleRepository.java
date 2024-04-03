package ma.emsi.jpakhattafi.repositories;

import ma.emsi.jpakhattafi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName (String roleName);
}
