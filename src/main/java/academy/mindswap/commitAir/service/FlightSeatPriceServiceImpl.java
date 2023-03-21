package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.FlightConverter;
import academy.mindswap.commitAir.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightSeatPriceServiceImpl implements FlightSeatPrice{

    FlightRepository flightRepository;
    FlightConverter flightConverter;

    @Autowired
    public FlightSeatPriceServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


}
