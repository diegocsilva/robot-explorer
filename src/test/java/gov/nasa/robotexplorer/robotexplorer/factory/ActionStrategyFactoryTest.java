package gov.nasa.robotexplorer.robotexplorer.factory;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.factory.ActionStrategyFactory;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnLeftActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnRightActionStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ActionStrategyFactoryTest {

    private ActionStrategyFactory turnRight = ActionStrategyFactory.TO_TURN_RIGHT;
    private ActionStrategyFactory turnLeft = ActionStrategyFactory.TO_TURN_LEFT;
    private ActionStrategyFactory moveOn = ActionStrategyFactory.MOVE_ON;

    @Test
    public void validCodeActions() {
        assertEquals("R", turnRight.getCode());
        assertEquals("L", turnLeft.getCode());
        assertEquals("M", moveOn.getCode());
    }

    @Test
    public void validGetActionByCode(){
        ActionStrategyFactory actionTurnRight = ActionStrategyFactory.getByCode('R');
        ActionStrategyFactory actionTurnLeft = ActionStrategyFactory.getByCode('L');
        ActionStrategyFactory actionMoveOn = ActionStrategyFactory.getByCode('M');

        assertEquals(ActionStrategyFactory.TO_TURN_RIGHT, actionTurnRight);
        assertEquals(ActionStrategyFactory.TO_TURN_LEFT, actionTurnLeft);
        assertEquals(ActionStrategyFactory.MOVE_ON, actionMoveOn);
    }

    @Test
    public void whenActionTurnRight_thenReturnGetValueNewTurnRightAction() {
        ActionStrategy actionStrategy = ActionStrategyFactory.getByCode('R').getAction();

        assertEquals(TurnRightActionStrategy.class, actionStrategy.getClass());
    }

    @Test
    public void whenActionTurnLeft_thenReturnGetValueNewTurnLeftAction() {
        ActionStrategy actionStrategy = ActionStrategyFactory.getByCode('L').getAction();

        assertEquals(TurnLeftActionStrategy.class, actionStrategy.getClass());
    }

    @Test
    public void whenActionMoveOn_thenReturnGetValueNewMoveOnAction() {
        ActionStrategy actionStrategy = ActionStrategyFactory.getByCode('M').getAction();

        assertEquals(MoveOnActionStrategy.class, actionStrategy.getClass());
    }

    @Test
    public void whenActionNotValid_thenReturnActionDoesNotValidException() {
        try {
            ActionStrategy actionStrategy = ActionStrategyFactory.getByCode('E').getAction();
            fail( "Should have thrown an exception" );
        }
        catch (ActionDoesNotValidException e) {
            assertEquals(ActionDoesNotValidException.class, e.getClass());
        }
    }

}
