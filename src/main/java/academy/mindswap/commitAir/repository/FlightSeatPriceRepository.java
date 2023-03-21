package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.FlightSeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatPriceRepository extends JpaRepository<FlightSeatPrice,Long> {
}