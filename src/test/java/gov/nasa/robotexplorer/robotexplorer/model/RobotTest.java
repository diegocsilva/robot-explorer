package gov.nasa.robotexplorer.robotexplorer.model;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.model.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void validConstructorWithParameters() {
        Position position = new Position(1, 2, CardinalPoint.EAST);
        Robot robot = new Robot(position);

        assertEquals(robot.getPosition(), position);
    }

    @Test
    public void validGettersAndSettersParameters() {
        Position position = new Position(1, 2, CardinalPoint.EAST);
        Robot robot = new Robot(position);

        Position position1 = new Position();
        robot.setPosition(position1);

        position.setCoordinateX(21);
        position.setCoordinateY(22);
        position.setDirection(CardinalPoint.SOUTH);

        assertEquals(robot.getPosition(),position1);
    }
}
