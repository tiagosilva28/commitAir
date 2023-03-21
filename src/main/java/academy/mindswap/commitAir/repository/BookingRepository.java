package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
