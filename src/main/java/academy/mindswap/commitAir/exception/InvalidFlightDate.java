package academy.mindswap.commitAir.exception;

public class InvalidFlightDate extends RuntimeException{

    public InvalidFlightDate(String message){
        super(message);
    }

    //IMPLEMENTENTION
    //
    //quando o input é uma data passada
    //existem voos na data selecionada
}
