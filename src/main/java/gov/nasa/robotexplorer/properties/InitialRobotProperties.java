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
public class InitialRobotProperties {

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
    public InitialRobotProperties(@Value("${robot.initial.COORDINATE_X}") Integer COORDINATE_X,
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
        InitialRobotProperties.COORDINATE_X = COORDINATE_X;
        InitialRobotProperties.COORDINATE_Y = COORDINATE_Y;
        InitialRobotProperties.AXIS_RANGE_X = AXIS_RANGE_X;
        InitialRobotProperties.AXIS_RANGE_Y = AXIS_RANGE_Y;
        InitialRobotProperties.SOUTH_LIMIT = SOUTH_LIMIT;
        InitialRobotProperties.NORTH_LIMIT = NORTH_LIMIT;
        InitialRobotProperties.WEST_LIMIT = WEST_LIMIT;
        InitialRobotProperties.EAST_LIMIT = EAST_LIMIT;
        InitialRobotProperties.DIRECTION = DIRECTION;
        InitialRobotProperties.messageActionNotValid = messageActionNotValid;
        InitialRobotProperties.messagePositionNotValid = messagePositionNotValid;
        InitialRobotProperties.messageDefaultError = messageDefaultError;
    }
}
