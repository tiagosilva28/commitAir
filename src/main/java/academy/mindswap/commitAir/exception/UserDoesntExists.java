package academy.mindswap.commitAir.exception;

import jakarta.persistence.EntityNotFoundException;

public class UserDoesntExists extends EntityNotFoundException {
    public UserDoesntExists(String message) {
        super(message);
    }
}
