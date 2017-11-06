package gov.nasa.robotexplorer.robotexplorer.properties;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.properties.InitialProperties;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotExplorerApplication.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.yml")
public class MessagesPropertiesTest {

    @Autowired
    private MessagesProperties messagesProperties;

    @Test
    public void whenRouteM_thenReturnListActionStrategyValidated() {

        String messageErrorDefault = messagesProperties.getMessage("error.defaul_error_message");
        String messageActionNotValid = messagesProperties.getMessage("error.action_not_valid");
        String messagePositionNotValid = messagesProperties.getMessage("error.position_not_valid");
        String messageInternalServerError = messagesProperties.getMessage("error.internal_server_error");

        assertTrue(messageErrorDefault != null);
        assertTrue(messageActionNotValid != null);
        assertTrue(messagePositionNotValid != null);
        assertTrue(messageInternalServerError != null);
    }


}
