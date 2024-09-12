package eventOrganizer;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesertaRepository extends JpaRepository<Event, Integer> {
}
