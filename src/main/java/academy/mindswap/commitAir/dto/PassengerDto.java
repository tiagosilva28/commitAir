package academy.mindswap.commitAir.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    @NotBlank(message = "Must have first name")
    private String firstName;

    @NotBlank(message = "Must have last name")
    private String lastName;

    @NotBlank (message = "Must have a Birth Date")
    private String dateOfBirth;

    @NotBlank (message = "Must have a Nationality")
    private String nationality;

}
