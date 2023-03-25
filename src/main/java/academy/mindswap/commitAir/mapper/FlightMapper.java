package academy.mindswap.commitAir.mapper;


import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.model.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    Flight fromDtoToEntity(FlightDto flightDto);
    FlightDto fromEntityToFlightDto(Flight flight);
}
