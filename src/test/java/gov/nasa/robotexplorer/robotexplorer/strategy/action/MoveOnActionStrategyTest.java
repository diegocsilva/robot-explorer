package gov.nasa.robotexplorer.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.domain.Axis;
import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.exception.MarsException;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoveOnActionStrategyTest {

    @Mock
    private MessagesProperties messagesProperties;

    @InjectMocks
    private MoveOnActionStrategy moveOnActionStrategy;

    @Before
    public void setUp(){
        mockMessagesProperties();
    }

    @Test
    public void whenMoveOnNorth_thenReturnPosition01N() {
        Position position = new Position(0, 0, CardinalPoint.NORTH);

        moveOnActionStrategy.execute(position);

        assertEquals("(0, 1, N)", position.toString());
    }

    @Test
    public void whenMoveOnSouth_thenReturnPosition00S() {
        Position position = new Position(0, 1, CardinalPoint.SOUTH);

        moveOnActionStrategy.execute(position);

        assertEquals("(0, 0, S)", position.toString());
    }

    @Test
    public void whenMoveOnEast_thenReturnPosition10E() {
        Position position = new Position(0, 0, CardinalPoint.EAST);

        moveOnActionStrategy.execute(position);

        assertEquals("(1, 0, E)", position.toString());
    }

    @Test
    public void whenMoveOnWest_thenReturnPosition10W() {
        Position position = new Position(1, 0, CardinalPoint.WEST);

        moveOnActionStrategy.execute(position);

        assertEquals("(0, 0, W)", position.toString());
    }

    private void mockMessagesProperties() {
        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");
    }
}
