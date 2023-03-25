package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserCreateDto;
import academy.mindswap.commitAir.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AirportService {

    List<AirportDto> getAirports();

}
