package by.javatr.bank.controller.exception;

public class ControllerException extends Exception {

    Exception innerException; //для пробрасывания исключения наверх

    public ControllerException() {
        super("Something was wrong with controller layer");
        this.innerException = null;
    }

    public ControllerException(String message, Exception innerException) {
        super(message);
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }
}
