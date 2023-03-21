package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
