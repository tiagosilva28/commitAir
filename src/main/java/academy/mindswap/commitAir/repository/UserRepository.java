package academy.mindswap.commitAir.repository;

import academy.mindswap.commitAir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    Optional<User> getUserById(Long heroId);

    @Query
    Optional<User> findUserByEmail(String email);

    @Query
    Optional<User> findUserByRole(Long heroId);
}
