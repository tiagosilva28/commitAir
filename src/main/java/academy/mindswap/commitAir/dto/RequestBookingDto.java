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
public class RequestBookingDto {
    private List<Long> passengerIds;
    private Long flightId;
}
