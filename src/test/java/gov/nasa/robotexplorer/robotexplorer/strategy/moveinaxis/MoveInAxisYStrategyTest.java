package gov.nasa.robotexplorer.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisYStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MoveInAxisYStrategyTest {

    @InjectMocks
    private MoveInAxisYStrategy moveInAxisYStrategy;

    @Test
    public void when00NMoveNorth1x_thenReturnPosition01N() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        moveInAxisYStrategy.move(position);

        assertEquals("(0, 1, N)", position.toString());
    }

    @Test
    public void when00NMoveNorth4x_thenReturnPosition04N() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);

        assertEquals("(0, 4, N)", position.toString());
    }

    @Test
    public void when01SMoveSouth1x_thenReturnPosition00S() {
        Position position = new Position(0, 1, CardinalPoint.SOUTH);

        moveInAxisYStrategy.move(position);

        assertEquals("(0, 0, S)", position.toString());
    }

    @Test
    public void when04SMoveSouth4x_thenReturnPosition00S() {
        Position position = new Position(0, 4, CardinalPoint.SOUTH);

        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);
        moveInAxisYStrategy.move(position);

        assertEquals("(0, 0, S)", position.toString());
    }
}
