package ma.emsi.jpakhattafi.repositories;

import ma.emsi.jpakhattafi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName );
}
