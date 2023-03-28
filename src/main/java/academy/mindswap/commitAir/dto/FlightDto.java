package academy.mindswap.commitAir.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDto {
    /*private String airline_iata;
    private String airline_icao;*/
    private String flight_iata;
    /*private String flight_icao;*/
    private String dep_iata;
    private String dep_time;
    private String arr_iata;
    private String arr_time;
    private int duration;
    private String status;
    private int availableSeats = this.setAvailableSeats(9);
    private int ticketPrice = this.setTicketPrice();

    public int setAvailableSeats(int availableSeats) {
        // Generate a random integer between 1 and 10 (inclusive) for AvailableSeats
        Random random = new Random();
        int randomSeats = (random.nextInt(availableSeats)) + 1;

        return randomSeats;
    }

    public int setTicketPrice() {
        // Generate a random integer between 1 and 10 (inclusive) for AvailableSeats
        Random random = new Random();
        int randomPrice = (random.nextInt(100)) + 1;

        return randomPrice;
    }


}
