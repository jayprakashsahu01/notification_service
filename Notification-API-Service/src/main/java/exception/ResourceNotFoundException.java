package exception;

import exception.handler.AbstractException;
import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException implements AbstractException {

    Integer statuscode;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Integer statuscode){
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
