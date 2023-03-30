package academy.mindswap.commitAir.exception;

public class ApiError extends RuntimeException {

    public ApiError(String message) {
        super(message);
    }
}
