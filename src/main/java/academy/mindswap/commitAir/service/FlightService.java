package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public interface FlightService {

    List<FlightDto> getAllFlightsFromAirport(String depIata) throws JsonProcessingException;

    FlightDto getFlightById(String flightIata) throws JsonProcessingException;

    FlightDto getFlightByDate(String flightDate);
    List<FlightDto> getAllFlightInformation(String depIata, String arrIata, String depTime) throws JsonProcessingException;
}
