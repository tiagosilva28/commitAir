package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.CityDto;
import academy.mindswap.commitAir.dto.CountryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CountryService {

    List<CountryDto> getCountries() throws JsonProcessingException;
}
