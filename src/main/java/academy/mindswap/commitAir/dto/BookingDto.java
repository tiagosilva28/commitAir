package academy.mindswap.commitAir.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private UserDto user;
    private List<PassengerDto> passengers;
    private FlightDto flight;
    private double finalPrice;

}
