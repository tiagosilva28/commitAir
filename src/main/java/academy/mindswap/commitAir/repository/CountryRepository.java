package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
