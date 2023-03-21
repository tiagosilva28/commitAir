package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
