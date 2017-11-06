package gov.nasa.robotexplorer.factory;

import gov.nasa.robotexplorer.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RobotFactory {

    @Autowired
    private PositionFactory positionFactory;

    public Robot create(){
        return new Robot(positionFactory.create());
    }
}
