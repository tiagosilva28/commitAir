package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.PassengerCreateDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PassengerService {
    PassengerDto createPassenger(PassengerDto passengerDto);
    PassengerDto getPassengerById(Long passengerId);
    List<PassengerDto> getAllPassengers();
    PassengerDto updatePassenger(Long passengerId, PassengerDto passengerDto);
    void deletePassenger(Long passengerId);


}
