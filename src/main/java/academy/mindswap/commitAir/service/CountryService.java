package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.CountryDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountries() throws JsonProcessingException;
}
