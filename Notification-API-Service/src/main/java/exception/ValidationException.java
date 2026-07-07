package exception;

import exception.handler.AbstractException;
import lombok.Getter;

public class ValidationException extends RuntimeException implements AbstractException {

    Integer statuscode;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message, Integer statuscode){
        super(message);
        this.statuscode = statuscode;
    }

    @Override
    public int getstatuscode() {
        return statuscode;
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
