package academy.mindswap.commitAir.dto;


import academy.mindswap.commitAir.model.Airport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDto {
    private String airline_iata;
    private String airline_icao;
    private String flight_iata;
    private String flight_icao;
    private String dep_iata;
    private String dep_icao;
    private String dep_time;
    private String arr_iata;
    private String arr_icao;
    private String arr_time;
    private int duration;

}
