package gov.nasa.robotexplorer.properties;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationEvent;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@PropertySource("classpath:/application.yml")
@Component
@Configuration
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

    public static Locale locale;

    @Autowired
    public InitialProperties(
            @Value("${robot.initial.COORDINATE_X}") Integer COORDINATE_X,
            @Value("${robot.initial.COORDINATE_Y}") Integer COORDINATE_Y,
            @Value("${robot.initial.AXIS_RANGE_X}") Integer AXIS_RANGE_X,
            @Value("${robot.initial.AXIS_RANGE_Y}") Integer AXIS_RANGE_Y,
            @Value("${robot.initial.SOUTH_LIMIT}") Integer SOUTH_LIMIT,
            @Value("#{ ${robot.initial.SOUTH_LIMIT} + ${robot.initial.AXIS_RANGE_Y} }") Integer NORTH_LIMIT,
            @Value("${robot.initial.WEST_LIMIT}") Integer WEST_LIMIT,
            @Value("#{${robot.initial.WEST_LIMIT} + ${robot.initial.AXIS_RANGE_X} }") Integer EAST_LIMIT,
            @Value("${robot.initial.DIRECTION}") CardinalPoint DIRECTION,
            @Value("${spring.mvc.locale}") Locale locale
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
        InitialProperties.locale = locale;
    }

    public static void setCoordinateX(Integer coordinateX) {
        COORDINATE_X = coordinateX;
    }

    public static void setCoordinateY(Integer coordinateY) {
        COORDINATE_Y = coordinateY;
    }

    public static void setAxisRangeX(Integer axisRangeX) {
        AXIS_RANGE_X = axisRangeX;
    }

    public static void setAxisRangeY(Integer axisRangeY) {
        AXIS_RANGE_Y = axisRangeY;
    }

    public static void setSouthLimit(Integer southLimit) {
        SOUTH_LIMIT = southLimit;
    }

    public static void setNorthLimit(Integer northLimit) {
        NORTH_LIMIT = northLimit;
    }

    public static void setWestLimit(Integer westLimit) {
        WEST_LIMIT = westLimit;
    }

    public static void setEastLimit(Integer eastLimit) {
        EAST_LIMIT = eastLimit;
    }

    public static void setDIRECTION(CardinalPoint DIRECTION) {
        InitialProperties.DIRECTION = DIRECTION;
    }

    public static void setLocale(Locale locale) {
        InitialProperties.locale = locale;
    }
}
