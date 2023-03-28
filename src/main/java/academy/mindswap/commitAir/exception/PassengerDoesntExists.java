package academy.mindswap.commitAir.exception;

import jakarta.persistence.EntityNotFoundException;

public class PassengerDoesntExists extends EntityNotFoundException {
    public PassengerDoesntExists(String message) {
        super(message);
    }
}
