package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.Flight;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FlightService {

    List<FlightDto> getAllFlightsFromAirport(String depIata) throws JsonProcessingException;

    FlightDto getFlightById(String flightIata) throws JsonProcessingException;
}
