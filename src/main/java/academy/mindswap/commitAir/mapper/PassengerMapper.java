package academy.mindswap.commitAir.mapper;

import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.model.Passenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger fromPassengerDtoToPassengerEntity (PassengerDto passengerDto);
    PassengerDto fromPassengerEntityToPassengerDto( Passenger passenger);
}
