package streamservice.userservice.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import streamservice.userservice.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findFirstByEmail(String email);
    User findFirstByUserName(String userName);
}
