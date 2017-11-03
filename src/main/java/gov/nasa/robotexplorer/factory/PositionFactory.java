package gov.nasa.robotexplorer.factory;

import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.InitialRobotProperties;
import org.springframework.stereotype.Component;

@Component
public class PositionFactory {

    public Position create(){
        return new Position(
                InitialRobotProperties.COORDINATE_X,
                InitialRobotProperties.COORDINATE_Y,
                InitialRobotProperties.DIRECTION);
    }
}
