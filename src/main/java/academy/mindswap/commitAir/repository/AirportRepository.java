package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
