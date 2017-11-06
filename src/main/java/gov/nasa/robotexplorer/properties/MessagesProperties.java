package gov.nasa.robotexplorer.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessagesProperties {

    @Autowired
    private MessageSource config;

    public String getMessage(String key){
        Locale locale = InitialProperties.locale;
        return config.getMessage(key, null, locale);
    }
}
