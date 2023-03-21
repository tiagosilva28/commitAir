package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
