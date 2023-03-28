package academy.mindswap.commitAir.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestBookingDto {

    private List<Long> passengerIds;
    private Long flightId;
}
