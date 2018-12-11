package my.web.repos;

import my.web.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepo extends JpaRepository<Track, Long> {

}
