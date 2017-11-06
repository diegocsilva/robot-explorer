package gov.nasa.robotexplorer.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.strategy.action.TurnRightActionStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TurnRightActionStrategyTest {

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private TurnRightActionStrategy turnRightActionStrategy;

    @Before
    public void setUp(){
        mockMessagesProperties();
    }

    @Test
    public void whenIsNorthAndTurnRight1x_thenReturnPositionEast() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, E)", position.toString());
    }

    @Test
    public void whenIsNorthAndTurnRight2x_thenReturnPositionSouth() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        turnRightActionStrategy.execute(position);
        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, S)", position.toString());
    }

    @Test
    public void whenIsEastAndTurnRight1x_thenReturnPositionSouth() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, S)", position.toString());
    }

    @Test
    public void whenIsEastAndTurnRight2x_thenReturnPositionWest() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        turnRightActionStrategy.execute(position);
        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    @Test
    public void whenIsSouthAndTurnRight1x_thenReturnPositionWest() {
        Position position = new Position(0, 0, CardinalPoint.SOUTH);

        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    @Test
    public void whenIsSouthAndTurnRight2x_thenReturnPositionNorth() {
        Position position = new Position(0, 0, CardinalPoint.SOUTH);

        turnRightActionStrategy.execute(position);
        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, N)", position.toString());
    }


    @Test
    public void whenIsWestAndTurnRight1x_thenReturnPositionNorth() {
        Position position = new Position(0, 0, CardinalPoint.WEST);

        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, N)", position.toString());
    }


    @Test
    public void whenIsWestAndTurnRight2x_thenReturnPositionEast() {
        Position position = new Position(0, 0, CardinalPoint.WEST);

        turnRightActionStrategy.execute(position);
        turnRightActionStrategy.execute(position);

        assertEquals("(0, 0, E)", position.toString());
    }

    private void mockMessagesProperties() {
        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");
    }
}
