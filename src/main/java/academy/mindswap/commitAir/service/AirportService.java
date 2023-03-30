package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.AirportDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface AirportService {

    List<AirportDto> getAllAirports() throws JsonProcessingException;

}
