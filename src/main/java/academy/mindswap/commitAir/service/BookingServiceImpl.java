package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.BookingDto;
import academy.mindswap.commitAir.dto.RequestBookingDto;
import academy.mindswap.commitAir.exception.FlightDoesntExists;
import academy.mindswap.commitAir.exception.InsufficientSeats;
import academy.mindswap.commitAir.exception.PassengerDoesntExists;
import academy.mindswap.commitAir.mapper.BookingMapper;
import academy.mindswap.commitAir.model.Booking;
import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.model.Passenger;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.BookingRepository;
import academy.mindswap.commitAir.repository.FlightRepository;
import academy.mindswap.commitAir.repository.PassengerRepository;
import academy.mindswap.commitAir.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingMapper bookingMapper;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    MailService mailService;

    @Override
    public BookingDto createBooking(RequestBookingDto requestBookingDto) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       /* User user = userRepository.findById(requestBookingDto.getUserId())
                .orElseThrow(() -> new UserDoesntExists("User Doesn't exists"));
        */

        List<Passenger> passengers = requestBookingDto.getPassengerIds().stream()
                .map(id -> passengerRepository.findById(id))
                .map(optionalPassenger -> optionalPassenger.orElseThrow(() -> new PassengerDoesntExists("Passenger ID: " + optionalPassenger.get().getId() + "Doesn't exists")))
                .collect(Collectors.toList());

        Flight flight = flightRepository.findById(requestBookingDto.getFlightId())
                .orElseThrow(() -> new FlightDoesntExists("Flight Doesn't exists"));

        if (flight.getAvailableSeats() < passengers.stream().count()) {
            throw new InsufficientSeats("Insufficient Seats Available");
        }

        flight.setAvailableSeats(flight.getAvailableSeats() - (int) passengers.stream().count());

        Booking booking = new Booking(user, passengers, flight);
        booking.setFinalPrice((int) passengers.stream().count() * flight.getTicketPrice());

        // Save the booking to the database
        bookingRepository.save(booking);

        mailService.sendEmail(user, flight, passengers.get(0));


        return bookingMapper.fromEntityToDto(booking);
    }
}
