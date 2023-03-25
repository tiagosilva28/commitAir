package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.AirportConverter;
import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.model.Airport;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService{

    AirportRepository airportRepository;
    AirportConverter airportConverter;

    @Override
    public List<AirportDto> getAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.parallelStream()
                .map(airportConverter::fromAirportEntityToAirportDto)
                .toList();
    }
}
