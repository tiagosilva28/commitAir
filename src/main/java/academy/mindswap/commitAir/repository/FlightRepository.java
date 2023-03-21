package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
