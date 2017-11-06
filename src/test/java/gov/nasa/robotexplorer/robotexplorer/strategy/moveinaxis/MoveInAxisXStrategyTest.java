package gov.nasa.robotexplorer.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisXStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MoveInAxisXStrategyTest {

    @InjectMocks
    private MoveInAxisXStrategy moveInAxisXStrategy;

    @Test
    public void when00EMoveEast1x_thenReturnPosition10E() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        moveInAxisXStrategy.move(position);

        assertEquals("(1, 0, E)", position.toString());
    }

    @Test
    public void when00EMoveEast4x_thenReturnPosition40E() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);

        assertEquals("(4, 0, E)", position.toString());
    }

    @Test
    public void when10WMoveWest1x_thenReturnPosition00W() {
        Position position = new Position(1, 0, CardinalPoint.WEST);

        moveInAxisXStrategy.move(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    @Test
    public void when40WMoveWest4x_thenReturnPosition00W() {
        Position position = new Position(4, 0, CardinalPoint.WEST);

        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);
        moveInAxisXStrategy.move(position);

        assertEquals("(0, 0, W)", position.toString());
    }
}
