package academy.mindswap.commitAir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CommitAirApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommitAirApplication.class, args);
    }

}
