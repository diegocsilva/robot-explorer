package gov.nasa.robotexplorer.robotexplorer.helper;

import gov.nasa.robotexplorer.helper.MessageSourceHelper;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageSourceHelperTest {

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private MessageSourceHelper messageSourceHelper;

    private Map<String, String> messagesError = new HashMap<>();

    @TestConfiguration
    static class MessageSourceHelperTestContextConfiguration {
        @Bean
        public MessageSourceHelper employeeService() {
            return new MessageSourceHelper();
        }
    }

    @Before
    public void setUp() {
        when(messagesProperties.getMessage("error.internal_server_error"))
                .thenReturn("internal_server_error");
    }

    @Test
    public void validCreateMessageSourceHelper() {
        assertTrue(messageSourceHelper.messagesPropertiesInject != null);
    }
}
