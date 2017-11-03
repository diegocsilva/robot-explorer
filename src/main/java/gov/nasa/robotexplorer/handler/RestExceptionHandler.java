package gov.nasa.robotexplorer.handler;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ActionDoesNotValidException.class)
    public ResponseEntity<?> handleActionDoesNotValidException(ActionDoesNotValidException e,
                                                               HttpServletRequest request){
        return ResponseEntity.badRequest().body(InitialProperties.messageActionNotValid);
    }

    @ExceptionHandler(PositionDoesNotValidException.class)
    public ResponseEntity<?> handlePositionDoesNotValidException(PositionDoesNotValidException e,
                                                               HttpServletRequest request){
        return ResponseEntity.badRequest().body(InitialProperties.messagePositionNotValid);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleDefaultRuntimeException(RuntimeException e,
                                                               HttpServletRequest request){
        return ResponseEntity.badRequest().body(InitialProperties.messageDefaultError);
    }
}
