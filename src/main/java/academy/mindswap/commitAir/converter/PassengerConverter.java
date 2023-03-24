package academy.mindswap.commitAir.converter;

import academy.mindswap.commitAir.dto.PassengerCreateDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.model.Passenger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerConverter {
    @Autowired
    ObjectMapper objectMapper;

    public PassengerDto fromPassengerEntityToPassengerDto(Passenger passenger){
        return PassengerDto.builder()
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .dateOfBirth(passenger.getDateOfBirth())
                .nationality(passenger.getNationality())
                .build();
    }

    public Passenger fromPassengerDtoToEntity(PassengerDto passengerDto){
        return objectMapper.convertValue(passengerDto, Passenger.class);
    }



    public Passenger fromPassengerCreateDtoEntity(PassengerCreateDto passengerCreateDto){
        return Passenger.builder()
                .firstName(passengerCreateDto.getFirstName())
                .lastName(passengerCreateDto.getLastName())
                .dateOfBirth(passengerCreateDto.getDateOfBirth())
                .nationality(passengerCreateDto.getNationality())
                .build();
    }

}