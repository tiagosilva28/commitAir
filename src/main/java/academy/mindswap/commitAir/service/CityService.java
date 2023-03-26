package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.CityDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {
    List<CityDto> getAllCities() throws JsonProcessingException;
}
