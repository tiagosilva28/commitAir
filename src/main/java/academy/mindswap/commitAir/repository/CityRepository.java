package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
