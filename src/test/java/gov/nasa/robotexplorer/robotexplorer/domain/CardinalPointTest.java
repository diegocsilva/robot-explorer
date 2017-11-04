package gov.nasa.robotexplorer.robotexplorer.domain;

import gov.nasa.robotexplorer.domain.Axis;
import gov.nasa.robotexplorer.domain.CardinalPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardinalPointTest {

    private CardinalPoint cardinalPointNorth = CardinalPoint.NORTH;
    private CardinalPoint cardinalPointWest = CardinalPoint.WEST;
    private CardinalPoint cardinalPointSouth = CardinalPoint.SOUTH;
    private CardinalPoint cardinalPointEast = CardinalPoint.EAST;

    @Test
    public void validOrderCardinalPoints() {
        CardinalPoint cardinalPointNorth = CardinalPoint.getByOrder(1);
        CardinalPoint cardinalPointWest = CardinalPoint.getByOrder(2);
        CardinalPoint cardinalPointSouth = CardinalPoint.getByOrder(3);
        CardinalPoint cardinalPointEast = CardinalPoint.getByOrder(4);
        CardinalPoint cardinalPointNotValidOrder = CardinalPoint.getByOrder(5);

        assertEquals(CardinalPoint.NORTH, cardinalPointNorth);
        assertEquals(CardinalPoint.WEST, cardinalPointWest);
        assertEquals(CardinalPoint.SOUTH, cardinalPointSouth);
        assertEquals(CardinalPoint.EAST, cardinalPointEast);
        assertEquals(null, cardinalPointNotValidOrder);
    }

    @Test
    public void validValueCardinalPoints() {
        assertEquals("N", cardinalPointNorth.getValue());
        assertEquals("W", cardinalPointWest.getValue());
        assertEquals("S", cardinalPointSouth.getValue());
        assertEquals("E", cardinalPointEast.getValue());
    }

    @Test
    public void validValueDeslocationInAxisCardinalPoints() {
        assertEquals(Integer.valueOf(1), cardinalPointNorth.getValueDeslocationInAxis());
        assertEquals(Integer.valueOf(-1), cardinalPointWest.getValueDeslocationInAxis());
        assertEquals(Integer.valueOf(-1), cardinalPointSouth.getValueDeslocationInAxis());
        assertEquals(Integer.valueOf(1), cardinalPointEast.getValueDeslocationInAxis());
    }

    @Test
    public void validValueAxisWhereMoveCardinalPoints() {
        assertEquals(Axis.AXIS_Y, cardinalPointNorth.getAxisWhereMove());
        assertEquals(Axis.AXIS_X, cardinalPointWest.getAxisWhereMove());
        assertEquals(Axis.AXIS_Y, cardinalPointSouth.getAxisWhereMove());
        assertEquals(Axis.AXIS_X, cardinalPointEast.getAxisWhereMove());
    }

    @Test
    public void validTurnLeft() {
        CardinalPoint cardinalPointW = cardinalPointNorth.getTurnLeft();
        assertEquals(cardinalPointW, CardinalPoint.WEST);
        CardinalPoint cardinalPointS = cardinalPointW.getTurnLeft() ;
        assertEquals(cardinalPointS, CardinalPoint.SOUTH);
        CardinalPoint cardinalPointE = cardinalPointS.getTurnLeft() ;
        assertEquals(cardinalPointE, CardinalPoint.EAST);
        CardinalPoint cardinalPointN = cardinalPointE.getTurnLeft() ;
        assertEquals(cardinalPointN, CardinalPoint.NORTH);
    }

    @Test
    public void whenNorthTurnLeft4x_thenReturnNorth() {
        CardinalPoint cardinalPoint = cardinalPointNorth.getTurnLeft()
                .getTurnLeft().getTurnLeft().getTurnLeft();

        assertEquals(cardinalPoint, CardinalPoint.NORTH);
    }

    @Test
    public void whenNorthTurnLeft2xAndTurnRight3x_thenReturnEast() {
        CardinalPoint cardinalPoint = cardinalPointNorth.getTurnLeft()
                .getTurnLeft().getTurnRight().getTurnRight().getTurnRight();

        assertEquals(cardinalPoint, CardinalPoint.EAST);
    }
}
