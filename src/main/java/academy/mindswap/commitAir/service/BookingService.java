package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.BookingDto;
import academy.mindswap.commitAir.dto.RequestBookingDto;


public interface BookingService {
    BookingDto createBooking(RequestBookingDto requestBookingDto);

    BookingDto getBookingById(Long id);

}
