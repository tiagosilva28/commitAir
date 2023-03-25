package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.PassengerConverter;
import academy.mindswap.commitAir.dto.PassengerCreateDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.model.Passenger;
import academy.mindswap.commitAir.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService{
    private PassengerRepository passengerRepository;
    private PassengerConverter passengerConverter;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerConverter passengerConverter){
        this.passengerRepository = passengerRepository;
        this.passengerConverter = passengerConverter;
    }

    @Override
    public PassengerDto createPassenger(PassengerCreateDto passengerCreateDto) {
        Passenger passenger = passengerConverter.fromPassengerCreateDtoEntity(passengerCreateDto);
        passenger = passengerRepository.save(passenger);
        return passengerConverter.fromPassengerEntityToPassengerDto(passenger);
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        Passenger passenger =passengerRepository.getReferenceById(passengerId);
        return passengerConverter.fromPassengerEntityToPassengerDto(passenger);
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<PassengerDto> passengerDtos = passengers.parallelStream()
                .map((passengerConverter::fromPassengerEntityToPassengerDto))
                .toList();
        return passengerDtos;
    }

    @Override
    public PassengerDto updatePassenger(Long passengerId, PassengerDto passengerDto) {
        Passenger existingPassenger = passengerRepository.getReferenceById(passengerId);
        if(existingPassenger == null){
            throw new IllegalArgumentException("User not found");
        }
        existingPassenger.setFirstName(passengerDto.getFirstName());
        existingPassenger.setLastName(passengerDto.getLastName());
        existingPassenger.setDateOfBirth(passengerDto.getDateOfBirth());
        existingPassenger.setNationality(passengerDto.getNationality());
        Passenger updatePassenger = passengerRepository.save(existingPassenger);
        return passengerConverter.fromPassengerEntityToPassengerDto(updatePassenger);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        Passenger passenger =passengerRepository.getReferenceById(passengerId);
        if(passenger == null){
            throw new IllegalArgumentException("Passenger not found");
        }
        passengerRepository.delete(passenger);
    }
}
