package academy.mindswap.commitAir.exception;

import jakarta.persistence.EntityNotFoundException;

public class BookingNotExists extends EntityNotFoundException {

    public BookingNotExists(String message) {
        super(message);
    }
}
