package academy.mindswap.commitAir.exception;

public class PasswordNotMatch extends RuntimeException {
    public PasswordNotMatch(String wrongPassword){
        super(wrongPassword);
    }

}
