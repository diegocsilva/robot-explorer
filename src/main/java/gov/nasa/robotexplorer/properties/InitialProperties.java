package gov.nasa.robotexplorer.properties;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/application.yml")
@Component
@Configuration
@ComponentScan
public class InitialProperties {

    public static Integer COORDINATE_X;

    public static Integer COORDINATE_Y;

    public static Integer AXIS_RANGE_X;

    public static Integer AXIS_RANGE_Y;

    public static Integer SOUTH_LIMIT;

    public static Integer NORTH_LIMIT;

    public static Integer WEST_LIMIT;

    public static Integer EAST_LIMIT;

    public static CardinalPoint DIRECTION;

    public static String messageActionNotValid;
    public static String messagePositionNotValid;
    public static String messageDefaultError;

    @Autowired
    public InitialProperties(@Value("${robot.initial.COORDINATE_X}") Integer COORDINATE_X,
                             @Value("${robot.initial.COORDINATE_Y}") Integer COORDINATE_Y,
                             @Value("${robot.initial.AXIS_RANGE_X}") Integer AXIS_RANGE_X,
                             @Value("${robot.initial.AXIS_RANGE_Y}") Integer AXIS_RANGE_Y,
                             @Value("${robot.initial.SOUTH_LIMIT}") Integer SOUTH_LIMIT,
                             @Value("#{ ${robot.initial.SOUTH_LIMIT} + ${robot.initial.AXIS_RANGE_Y} }") Integer NORTH_LIMIT,
                             @Value("${robot.initial.WEST_LIMIT}") Integer WEST_LIMIT,
                             @Value("#{${robot.initial.WEST_LIMIT} + ${robot.initial.AXIS_RANGE_X} }") Integer EAST_LIMIT,
                             @Value("${robot.initial.DIRECTION}") CardinalPoint DIRECTION,
                             @Value("${robot.exception.message.action_not_valid}") String messageActionNotValid,
                             @Value("${robot.exception.message.position_not_valid}") String messagePositionNotValid,
                             @Value("${robot.exception.message.defaul_error_message}") String messageDefaultError
                                  ) {
        InitialProperties.COORDINATE_X = COORDINATE_X;
        InitialProperties.COORDINATE_Y = COORDINATE_Y;
        InitialProperties.AXIS_RANGE_X = AXIS_RANGE_X;
        InitialProperties.AXIS_RANGE_Y = AXIS_RANGE_Y;
        InitialProperties.SOUTH_LIMIT = SOUTH_LIMIT;
        InitialProperties.NORTH_LIMIT = NORTH_LIMIT;
        InitialProperties.WEST_LIMIT = WEST_LIMIT;
        InitialProperties.EAST_LIMIT = EAST_LIMIT;
        InitialProperties.DIRECTION = DIRECTION;
        InitialProperties.messageActionNotValid = messageActionNotValid;
        InitialProperties.messagePositionNotValid = messagePositionNotValid;
        InitialProperties.messageDefaultError = messageDefaultError;
    }
}
