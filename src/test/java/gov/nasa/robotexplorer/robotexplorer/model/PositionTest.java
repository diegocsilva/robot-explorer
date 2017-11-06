package gov.nasa.robotexplorer.robotexplorer.model;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void validConstructorWithParameters() {
        Position position = new Position(1, 2, CardinalPoint.EAST);
        assertEquals(Integer.valueOf(1),position.getCoordinateX());
        assertEquals(Integer.valueOf(2),position.getCoordinateY());
        assertEquals(CardinalPoint.EAST,position.getDirection());
    }

    @Test
    public void validConstructorDefault() {
        Position position = new Position();
        assertEquals(null,position.getCoordinateX());
        assertEquals(null,position.getCoordinateY());
        assertEquals(null,position.getDirection());
    }

    @Test
    public void validGettersAndSettersParameters() {
        Position position = new Position(1, 2, CardinalPoint.EAST);
        position.setCoordinateX(21);
        position.setCoordinateY(22);
        position.setDirection(CardinalPoint.SOUTH);

        assertEquals(Integer.valueOf(21),position.getCoordinateX());
        assertEquals(Integer.valueOf(22),position.getCoordinateY());
        assertEquals(CardinalPoint.SOUTH,position.getDirection());
    }

    @Test
    public void validToStringFormat() {
        Position position = new Position(1, 2, CardinalPoint.EAST);
        assertEquals("(1, 2, E)",position.toString());
    }
}
