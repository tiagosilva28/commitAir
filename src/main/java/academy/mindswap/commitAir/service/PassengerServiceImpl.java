package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.PassengerConverter;
import academy.mindswap.commitAir.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    PassengerRepository passengerRepository;
    PassengerConverter passengerConverter;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
}
