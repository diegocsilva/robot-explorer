package gov.nasa.robotexplorer.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnLeftActionStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TurnLeftActionStrategyTest {

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private TurnLeftActionStrategy turnLeftActionStrategy;

    @Before
    public void setUp(){
        mockMessagesProperties();
    }

    @Test
    public void whenIsNorthAndTurnLeft1x_thenReturnPositionWest() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    @Test
    public void whenIsNorthAndTurnLeft2x_thenReturnPositionSouth() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        turnLeftActionStrategy.execute(position);
        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, S)", position.toString());
    }


    @Test
    public void whenIsWestAndTurnLeft1x_thenReturnPositionSouth() {
        Position position = new Position(0, 0, CardinalPoint.WEST);

        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, S)", position.toString());
    }


    @Test
    public void whenIsWestAndTurnLeft2x_thenReturnPositionEast() {
        Position position = new Position(0, 0, CardinalPoint.WEST);

        turnLeftActionStrategy.execute(position);
        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, E)", position.toString());
    }

    @Test
    public void whenIsSouthAndTurnLeft1x_thenReturnPositionEast() {
        Position position = new Position(0, 0, CardinalPoint.SOUTH);

        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, E)", position.toString());
    }

    @Test
    public void whenIsSouthAndTurnLeft2x_thenReturnPositionNorth() {
        Position position = new Position(0, 0, CardinalPoint.SOUTH);

        turnLeftActionStrategy.execute(position);
        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, N)", position.toString());
    }

    @Test
    public void whenIsEastAndTurnLeft1x_thenReturnPositionNorth() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, N)", position.toString());
    }

    @Test
    public void whenIsEastAndTurnLeft2x_thenReturnPositionWest() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        turnLeftActionStrategy.execute(position);
        turnLeftActionStrategy.execute(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    private void mockMessagesProperties() {
        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");
    }
}
