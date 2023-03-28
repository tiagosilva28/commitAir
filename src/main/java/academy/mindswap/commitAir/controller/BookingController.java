package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.service.BookingService;
import academy.mindswap.commitAir.service.MailService;
import academy.mindswap.commitAir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private MailService mailService;
    private UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, MailService mailService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.mailService = mailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> sendConfirmationEmail(@PathVariable Long id){

        UserDto userDto = userService.getUserById(id);

        //mailService.sendEmail(userDto);
        mailService.sendEmail2(userDto, new FlightDto("Teste", "teste", "teste", "teste", "teste", 12, "scheduled"), new PassengerDto("Tiago", "Cenas", "1985-01-01", "Angolano"));
        //mailService.sendEmail2(userDto, new FlightDto(), new PassengerDto());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
