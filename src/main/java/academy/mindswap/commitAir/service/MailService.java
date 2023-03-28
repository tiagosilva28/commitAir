package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.model.Passenger;

public interface MailService {

    void sendEmail(UserDto userDto);
    void sendEmail2(UserDto userDto, FlightDto flight, PassengerDto passenger);
}
