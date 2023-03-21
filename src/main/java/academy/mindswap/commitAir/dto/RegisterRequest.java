package academy.mindswap.commitAir.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Must have First Name")
    private String firstName;
    @NotBlank(message = "Must have Last Name")
    private String lastName;
    @Email(message = "Email must be valid")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    private String email;

    @Min(value = 8, message = "Password must be at least 8 characters long")
    @NotBlank (message = "Must have password")
    private String password;

    @Min(value = 8, message = "Password must be at least 8 characters long")
    @NotBlank (message = "Must have password")
    private String retypedPassword;

}
