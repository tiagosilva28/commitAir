package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.BookingDto;
import academy.mindswap.commitAir.dto.RequestBookingDto;
import academy.mindswap.commitAir.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody RequestBookingDto booking) {

        BookingDto savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        BookingDto bookingDto = bookingService.getBookingById(id);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }
}
