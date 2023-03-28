package academy.mindswap.commitAir.exception;

import jakarta.persistence.EntityNotFoundException;

public class FlightDoesntExists extends EntityNotFoundException {

    public FlightDoesntExists(String message) {
        super(message);
    }
}
