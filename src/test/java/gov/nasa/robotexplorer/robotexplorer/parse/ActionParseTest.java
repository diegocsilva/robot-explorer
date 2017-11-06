package gov.nasa.robotexplorer.robotexplorer.parse;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.helper.MessageSourceHelper;
import gov.nasa.robotexplorer.parse.ActionParse;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnLeftActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnRightActionStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MessageSourceHelper.class)
public class ActionParseTest {

    @InjectMocks
    private ActionParse actionParse;

    @Before
    public void setUp(){
        mockStatic(MessageSourceHelper.class);
        given(MessageSourceHelper.getMessage("error.action_not_valid")).willReturn("action_not_valid");
    }

    @Test
    public void whenRouteM_thenReturnListActionStrategyValidated() {
        List<ActionStrategy> actionsStrategie = new ArrayList<>();

        actionsStrategie.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 1));

        List<ActionStrategy> actionsStrategieOfParse = actionParse.parse("M");

        assertEquals(actionsStrategie, actionsStrategieOfParse);
    }

    @Test
    public void whenRouteR_thenReturnListActionStrategyValidated() {
        List<ActionStrategy> actionsStrategie = new ArrayList<>();

        actionsStrategie.addAll(buildListActionStrategyByType(TurnRightActionStrategy.class, 1));

        List<ActionStrategy> actionsStrategieOfParse = actionParse.parse("R");

        assertEquals(actionsStrategie, actionsStrategieOfParse);
    }

    @Test
    public void whenRouteL_thenReturnListActionStrategyValidated() {
        List<ActionStrategy> actionsStrategie = new ArrayList<>();

        actionsStrategie.addAll(buildListActionStrategyByType(TurnLeftActionStrategy.class, 1));

        List<ActionStrategy> actionsStrategieOfParse = actionParse.parse("L");

        assertEquals(actionsStrategie, actionsStrategieOfParse);
    }

    @Test
    public void whenRouteMMMRRRLLL_thenReturnListActionStrategyValidated() {
        List<ActionStrategy> actionsStrategie = new ArrayList<>();

        actionsStrategie.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 3));
        actionsStrategie.addAll(buildListActionStrategyByType(TurnRightActionStrategy.class, 3));
        actionsStrategie.addAll(buildListActionStrategyByType(TurnLeftActionStrategy.class, 3));

        List<ActionStrategy> actionsStrategieOfParse = actionParse.parse("MMMRRRLLL");

        assertEquals(actionsStrategie, actionsStrategieOfParse);
    }

    @Test
    public void whenRouteInvalid_thenReturnActionNotValidException() {
        List<ActionStrategy> actionsStrategie = new ArrayList<>();

        try {
            List<ActionStrategy> actionsStrategieOfParse = actionParse.parse("PPP");
            fail( "Should have thrown an exception" );
        }catch (Exception e){
            assertTrue(e instanceof ActionDoesNotValidException);
            assertEquals(e.getMessage(), MessageSourceHelper.getMessage("error.action_not_valid"));
        }

    }

    public List<ActionStrategy> buildListActionStrategyByType(Class classe, Integer amount){
        List<ActionStrategy> list= new ArrayList<>();

        IntStream.range(0, amount)
                .forEach(i -> list.add(buildActionStrategy(classe)));

        return list;
    }

    private ActionStrategy buildActionStrategy(Class classe){
        try {
            return (ActionStrategy) classe.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }
}
