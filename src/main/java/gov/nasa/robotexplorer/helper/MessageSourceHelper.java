package gov.nasa.robotexplorer.helper;

import gov.nasa.robotexplorer.properties.MessagesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageSourceHelper {

    @Autowired
    public MessagesProperties messagesPropertiesInject;

    public static MessagesProperties messagesProperties;

    public static String getMessage(String messageKey) {
        return messagesProperties.getMessage(messageKey);
    }

    @PostConstruct
    public void postConstruct() {
        messagesProperties = messagesPropertiesInject;
    }
}