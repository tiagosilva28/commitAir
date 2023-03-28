package academy.mindswap.commitAir.service;


import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.model.Passenger;
import academy.mindswap.commitAir.model.User;

public interface MailService {

    void sendEmail(User user, Flight flight, Passenger passenger);
}

