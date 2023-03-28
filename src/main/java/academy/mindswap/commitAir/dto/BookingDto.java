package academy.mindswap.commitAir.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private UserDto user;
    private List<PassengerDto> passengers;
    private FlightDto flight;
    private double finalPrice;


}
