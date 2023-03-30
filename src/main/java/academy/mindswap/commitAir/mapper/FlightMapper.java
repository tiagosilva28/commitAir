package academy.mindswap.commitAir.mapper;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.model.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    Flight fromDtoToEntity(FlightDto flightDto);

    List<Flight> fromDtoListToEntity(List<FlightDto> flightDto);

    FlightDto fromEntityToFlightDto(Flight flight);
}
