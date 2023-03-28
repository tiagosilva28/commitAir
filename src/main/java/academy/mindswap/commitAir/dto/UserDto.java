package academy.mindswap.commitAir.dto;


import academy.mindswap.commitAir.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@RedisHash
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Must have first name")
    private String firstName;

    @NotBlank(message = "Must have last name")
    private String lastName;

    @Email(message = "Email must be valid")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    private String email;

    @NotBlank (message = "Must have a Birth Date")
    private Date dateOfBirth;

    @NotBlank (message = "Must have a Nationality")
    private String nationality;

    private Role role;
}
