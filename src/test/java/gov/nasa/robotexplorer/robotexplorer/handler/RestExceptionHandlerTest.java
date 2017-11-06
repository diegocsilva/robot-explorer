package gov.nasa.robotexplorer.robotexplorer.handler;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.exception.MarsException;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.handler.RestExceptionHandler;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestExceptionHandlerTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private Logger logger;

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private RestExceptionHandler restExceptionHandler;

    private Map<String, String> messagesError = new HashMap<>();


    @Before
    public void setUp() {
        messagesError.put("default_error_message", "default_error_message");
        messagesError.put("action_not_valid", "action_not_valid");
        messagesError.put("position_not_valid", "position_not_valid");
        messagesError.put("internal_server_error", "internal_server_error");

        when(messagesProperties.getMessage("error.defaul_error_message"))
                .thenReturn("default_error_message");

        when(messagesProperties.getMessage("error.action_not_valid"))
                .thenReturn("action_not_valid");

        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");

        when(messagesProperties.getMessage("error.internal_server_error"))
                .thenReturn("internal_server_error");
    }


    @Test
    public void whenActionDoesNotValidException_thenReturnBadRequestAndMessage() {
        ResponseEntity responseEntity = restExceptionHandler
                .handler(new ActionDoesNotValidException("action_not_valid"), request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(messagesError.get("action_not_valid"), responseEntity.getBody());
    }

    @Test
    public void whenPositionDoesNotValidException_thenReturnBadRequestAndMessage() {
        ResponseEntity responseEntity = restExceptionHandler
                .handler(new PositionDoesNotValidException("position_not_valid"), request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(messagesError.get("position_not_valid"), responseEntity.getBody());
    }

    @Test
    public void whenMarsException_thenReturnBadRequestAndMessage() {
        ResponseEntity responseEntity = restExceptionHandler
                .handler(new MarsException("default_error_message"), request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(messagesError.get("default_error_message"), responseEntity.getBody());
    }

    @Test
    public void whenException_thenReturnInternalServerErrorStatusAndMessage() {
        ResponseEntity responseEntity = restExceptionHandler
                .handleDefaultException(new Exception("internal_server_error"), request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(messagesError.get("internal_server_error"), responseEntity.getBody());
    }
}
