package gov.nasa.robotexplorer.factory;

import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.InitialProperties;
import org.springframework.stereotype.Component;

@Component
public class PositionFactory {

    public Position create(){
        return new Position(
                InitialProperties.COORDINATE_X,
                InitialProperties.COORDINATE_Y,
                InitialProperties.DIRECTION);
    }
}
