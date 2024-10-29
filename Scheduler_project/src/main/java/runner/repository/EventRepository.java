package runner.repository;

import runner.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import runner.model.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByEventId(UUID eventId);
}
