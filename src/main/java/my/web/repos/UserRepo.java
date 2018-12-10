package my.web.repos;

import my.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);
    List<User> findByUsernameLike(String username);

}
