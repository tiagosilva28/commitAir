package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
