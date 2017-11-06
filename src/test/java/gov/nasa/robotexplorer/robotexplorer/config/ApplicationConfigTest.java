package gov.nasa.robotexplorer.robotexplorer.config;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import gov.nasa.robotexplorer.config.ApplicationConfig;
import gov.nasa.robotexplorer.handler.RestExceptionHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.LocaleResolver;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RobotExplorerApplication.class)
public class ApplicationConfigTest {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Test
    public void validCreateLocaleResolver() {
        LocaleResolver localeResolver = applicationConfig.localeResolver();

        assertTrue(localeResolver != null);
    }

    @Test
    public void validCreateMessageSource() {
        MessageSource messageSource = applicationConfig.messageSource();

        assertTrue(messageSource != null);
    }

    @Test
    public void validCreateLogger() throws NoSuchMethodException {
        InjectionPoint injectionPoint = buildInjectPoint(RestExceptionHandler.class, "handler");

        Logger logger  = applicationConfig.logger(injectionPoint);

        assertTrue(logger != null);
    }

    private InjectionPoint buildInjectPoint(Class classe, String methodName){
        Method[] methods = classe.getMethods();

        List<Method> methodsList = Arrays.stream(methods)
                .filter(method1 -> Objects.equals(method1.getName(), methodName))
                .collect(Collectors.toList());

        MethodParameter methodParameter = new MethodParameter(methodsList.get(0), 1);
        return new DependencyDescriptor(methodParameter, true);
    }
}
