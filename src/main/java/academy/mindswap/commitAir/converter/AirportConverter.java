package academy.mindswap.commitAir.converter;

import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.model.Airport;

import org.springframework.stereotype.Component;

@Component
public class AirportConverter {

    public AirportDto fromAirportEntityToAirportDto(Airport airport) {
        return AirportDto.builder()
                .name(airport.getName())
                .iata_code(airport.getIata())
                .build();
    }
}
