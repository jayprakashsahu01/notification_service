package exception.handler;

import com.notification.api.utils.CommonUtils;
import exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.function.Supplier;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<String> handleValidationException(ValidationException exception){
        return genericExceptionHandler(exception,
                () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage()));
    }

    public ResponseEntity<String> handleResourceNotFoundException(ValidationException exception){
        return genericExceptionHandler(exception,
                () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage()));
    }

    public ResponseEntity<String > genericExceptionHandler(final AbstractException expection,
                                                           final Supplier<ResponseEntity<String>>runner){
        if (CommonUtils.isNotEmpty(expection.getstatuscode())){
            return ResponseEntity.status(expection.getstatuscode()).body(expection.getErrorMessage());
        }
        return runner.get();
    }
}
