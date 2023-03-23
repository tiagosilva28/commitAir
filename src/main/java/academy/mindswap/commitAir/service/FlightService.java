package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FlightService {

    List<Flight> getAllFlights();

    Flight getFlightById(String flightcode);
}
