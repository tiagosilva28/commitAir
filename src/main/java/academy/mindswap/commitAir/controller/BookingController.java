package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.repository.UserRepository;
import academy.mindswap.commitAir.service.BookingService;
import academy.mindswap.commitAir.service.MailService;
import academy.mindswap.commitAir.service.MaleServiceImpl;
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
    public ResponseEntity<UserDto> sendConfimationEmail(@PathVariable Long id){

        UserDto userDto = userService.getUserById(id);

        mailService.sendEmail(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
