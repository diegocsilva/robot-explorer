package gov.nasa.robotexplorer.handler;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.exception.MarsException;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private Logger logger;

    @Autowired
    private MessagesProperties messagesProperties;

    @ExceptionHandler(MarsException.class)
    public ResponseEntity<?> handler(MarsException e, HttpServletRequest request){
        if (e instanceof ActionDoesNotValidException){
            logger.error("Action does not Valid", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }else if (e instanceof PositionDoesNotValidException){
            logger.error("Position does not Valid", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }else {
            logger.error("An unexpected error occurred on route.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleDefaultException(Exception e,
                                                               HttpServletRequest request){
        logger.error("An unexpected error occurred with robot-explorer.", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(messagesProperties.getMessage("error.internal_server_error"));
    }
}
