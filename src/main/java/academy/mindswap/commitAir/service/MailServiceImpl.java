package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.model.Passenger;
import academy.mindswap.commitAir.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(User user, Flight flight, Passenger passenger) {

        String flightInformation =
                "Dear, " + user.getFirstName() + " " + user.getLastName() + ",\n \n" +
                        "Passengers: " + passenger.getFirstName() + " " + passenger.getLastName() + "\n" +
                        "Your booking flight details: \n" +
                        "Flight: " + flight.getFlight_iata() + "\n" +
                        "From: " + flight.getDep_iata() + "\n" +
                        "To: " + flight.getArr_iata() + "\n" +
                        "Departure date/time: " + flight.getDep_time() + "\n" +
                        "Arrival date/time: " + flight.getArr_time();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject("COMMIT AIR - Your Flight information");
        mail.setText(flightInformation + "\n \n Have a nice trip!");
        javaMailSender.send(mail);

    }
}
