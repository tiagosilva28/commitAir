package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MaleServiceImpl implements MailService{

    JavaMailSender javaMailSender;

    @Autowired
    public MaleServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendEmail(UserDto userDto) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userDto.getEmail());
        mail.setSubject("COMMIT AIR - Your Booking Flight information");
        mail.setText("Hurray! You have done that dude...");
        javaMailSender.send(mail);
    }

    @Override
    public void sendEmail2(UserDto userDto, FlightDto flight, PassengerDto passenger) {

        String flightInformation = passenger.getFirstName() + " " + passenger.getLastName() + ",\n" +
                "Your booking flight details: \n" +
                "Flight: " + flight.getFlight_iata() +
                "From: " + flight.getDep_iata() +
                "To: " + flight.getArr_iata() +
                "Departure date/time: " + flight.getDep_time() +
                "Arrival date/time" + flight.getArr_time();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userDto.getEmail());
        mail.setSubject("COMMIT AIR - Your Flight information");
        mail.setText(flightInformation + "\nHave a nice trip!");
        javaMailSender.send(mail);
    }

}
