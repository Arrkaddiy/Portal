package my.web.repos;

import my.web.domain.User;
import my.web.domain.IncludeMail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncludeMailRepo extends JpaRepository<IncludeMail, Long> {

    List<IncludeMail> findByDeliveredFalse();
    List<IncludeMail> findByUserToAndDeliveredTrue (User user);
    List<IncludeMail> findByUserToAndDeliveredTrueAndReadFalse(User user);
    List<IncludeMail> findByUserFrom(User user);

}
