package gov.nasa.robotexplorer.robotexplorer.properties;

import gov.nasa.robotexplorer.RobotExplorerApplication;
import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
public class InitialPropertiesTest {

    @Autowired
    private InitialProperties initialProperties;

    @Test
    public void whenRouteM_thenReturnListActionStrategyValidated() {

        Integer COORDINATE_X = InitialProperties.COORDINATE_X;
        Integer COORDINATE_Y = InitialProperties.COORDINATE_Y;
        Integer AXIS_RANGE_X = InitialProperties.AXIS_RANGE_X;
        Integer AXIS_RANGE_Y = InitialProperties.AXIS_RANGE_Y;
        Integer SOUTH_LIMIT = InitialProperties.SOUTH_LIMIT;
        Integer NORTH_LIMIT = InitialProperties.NORTH_LIMIT;
        Integer WEST_LIMIT = InitialProperties.WEST_LIMIT;
        Integer EAST_LIMIT = InitialProperties.EAST_LIMIT;
        CardinalPoint DIRECTION = InitialProperties.DIRECTION;
        Locale locale = InitialProperties.locale;

        assertTrue(COORDINATE_X != null);
        assertTrue(COORDINATE_Y != null);
        assertTrue(AXIS_RANGE_X != null);
        assertTrue(AXIS_RANGE_Y != null);
        assertTrue(SOUTH_LIMIT != null);
        assertTrue(NORTH_LIMIT != null);
        assertTrue(WEST_LIMIT != null);
        assertTrue(EAST_LIMIT != null);
        assertTrue(DIRECTION != null);
        assertTrue(locale != null);
    }


}
