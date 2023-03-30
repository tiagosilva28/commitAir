package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.mapper.PassengerMapper;
import academy.mindswap.commitAir.model.Passenger;
import academy.mindswap.commitAir.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    PassengerRepository passengerRepository;
    PassengerMapper passengerMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        Passenger passenger = passengerMapper.fromPassengerDtoToPassengerEntity(passengerDto);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.fromPassengerEntityToPassengerDto(passenger);
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        Passenger passenger = passengerRepository.getReferenceById(passengerId);
        return passengerMapper.fromPassengerEntityToPassengerDto(passenger);
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<PassengerDto> passengerDtos = passengers.parallelStream()
                .map((passengerMapper::fromPassengerEntityToPassengerDto))
                .toList();
        return passengerDtos;
    }

    @Override
    public PassengerDto updatePassenger(Long passengerId, PassengerDto passengerDto) {
        Passenger existingPassenger = passengerRepository.getReferenceById(passengerId);
        if (existingPassenger == null) {
            throw new IllegalArgumentException("User not found");
        }
        existingPassenger.setFirstName(passengerDto.getFirstName());
        existingPassenger.setLastName(passengerDto.getLastName());
        existingPassenger.setDateOfBirth(passengerDto.getDateOfBirth());
        existingPassenger.setNationality(passengerDto.getNationality());
        Passenger updatePassenger = passengerRepository.save(existingPassenger);
        return passengerMapper.fromPassengerEntityToPassengerDto(updatePassenger);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        Passenger passenger = passengerRepository.getReferenceById(passengerId);
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger not found");
        }
        passengerRepository.delete(passenger);
    }
}
