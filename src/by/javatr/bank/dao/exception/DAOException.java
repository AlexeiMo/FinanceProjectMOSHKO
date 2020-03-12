package by.javatr.bank.dao.exception;

public class DAOException extends Exception{

    Exception innerException; //для пробрасывания исключения наверх

    public DAOException() {
        super("Something was wrong with data source");
        this.innerException = null;
    }

    public DAOException(String message, Exception innerException) {
        super(message);
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }
}
