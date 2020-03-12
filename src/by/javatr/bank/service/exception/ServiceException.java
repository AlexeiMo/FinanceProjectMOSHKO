package by.javatr.bank.service.exception;

public class ServiceException extends Exception{

    Exception innerException; //для пробрасывания исключения наверх

    public ServiceException() {
        super("Something was wrong with service layer");
        this.innerException = null;
    }

    public ServiceException(String message, Exception innerException) {
        super(message);
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }
}
