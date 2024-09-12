package eventOrganizer;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanitiaRepository extends JpaRepository<Event, Integer> {
}
