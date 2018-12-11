package my.web.repos;

import my.web.domain.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepo extends JpaRepository<MediaType, Long> {
}
