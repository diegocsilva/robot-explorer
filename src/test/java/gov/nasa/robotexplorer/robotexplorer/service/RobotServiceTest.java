
package gov.nasa.robotexplorer.robotexplorer.service;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.exception.PositionDoesNotValidException;
import gov.nasa.robotexplorer.factory.RobotFactory;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.model.Robot;
import gov.nasa.robotexplorer.parse.ActionParse;
import gov.nasa.robotexplorer.properties.InitialProperties;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.service.PositionService;
import gov.nasa.robotexplorer.service.RobotService;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnLeftActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnRightActionStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(InitialProperties.class)
public class RobotServiceTest {

    @Mock
    private ActionParse actionParse;

    @Mock
    private RobotFactory robotFactory;

    @Mock
    private MessagesProperties messagesProperties;

    @MockBean
    private PositionService positionService;

    @InjectMocks
    private RobotService robotService;

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        mockProperties();
        mockRobotFactory();
        mockMessagesProperties();
        mockListActionsStrategy();
        setPositionService();
    }

    private void mockListActionsStrategy() {
        List<ActionStrategy> actions =
                buildListActionStrategyByType(MoveOnActionStrategy.class, 5);

        mockReturnParse("MMMMM", actions);

        actions = buildListActionStrategyByType(MoveOnActionStrategy.class, 10);

        mockReturnParse("MMMMMMMMMM", actions);

        actions = buildListActionStrategyByType(MoveOnActionStrategy.class, 5);
        actions.add(buildActionStrategy(TurnRightActionStrategy.class));
        actions.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 5));
        actions.add(buildActionStrategy(TurnRightActionStrategy.class));
        actions.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 5));
        actions.add(buildActionStrategy(TurnRightActionStrategy.class));
        actions.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 5));
        actions.add(buildActionStrategy(TurnRightActionStrategy.class));

        mockReturnParse("MMMMMRMMMMMRMMMMMRMMMMMR", actions);

        actions = buildListActionStrategyByType(TurnLeftActionStrategy.class, 1);
        actions.add(buildActionStrategy(MoveOnActionStrategy.class));

        mockReturnParse("LM", actions);

        actions = buildListActionStrategyByType(TurnLeftActionStrategy.class, 2);
        actions.add(buildActionStrategy(MoveOnActionStrategy.class));

        mockReturnParse("LLM", actions);

        actions = buildListActionStrategyByType(TurnRightActionStrategy.class, 1);
        actions.addAll(buildListActionStrategyByType(MoveOnActionStrategy.class, 5));

        mockReturnParse("RMMMMM", actions);

    }

    @Test
    public void whenRouteMMMMM_ThenReturnPosition05N() {
        Robot robot = robotService.executeTheRoute("MMMMM");
        assertEquals("(0, 5, N)", robot.getPosition().toString());
    }

    @Test
    public void whenRouteMMMMMRMMMMMRMMMMMRMMMMMR_ThenReturnPosition00N() {
        Robot robot = robotService.executeTheRoute("MMMMMRMMMMMRMMMMMRMMMMMR");
        assertEquals("(0, 0, N)", robot.getPosition().toString());
    }

    @Test
    public void whenRouteRMMMMM_ThenReturnPosition50E() {
        Robot robot = robotService.executeTheRoute("RMMMMM");
        assertEquals("(5, 0, E)", robot.getPosition().toString());
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenRouteLM_ThenReturnPositionNotValidException() {
        Robot robot = robotService.executeTheRoute("LM");
        fail("fail validation in validPosition");
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenRouteMMMMMMMMMM_ThenReturnPositionNotValidException() {
        Robot robot = robotService.executeTheRoute("MMMMMMMMMM");
        fail("fail validation in validPosition");
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void whenRouteLLM_ThenReturnPositionNotValidException() {
        Robot robot = robotService.executeTheRoute("LM");
        fail("fail validation in validPosition");
    }

    public List<ActionStrategy> buildListActionStrategyByType(Class classe, Integer amount) {
        List<ActionStrategy> list = new ArrayList<>();

        IntStream.range(0, amount)
                .forEach(i -> list.add(buildActionStrategy(classe)));

        return list;
    }

    private ActionStrategy buildActionStrategy(Class classe) {
        try {
            return (ActionStrategy) classe.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }

    private void mockProperties() {
        InitialProperties.setCoordinateX(0);
        InitialProperties.setCoordinateY(0);
        InitialProperties.setDIRECTION(CardinalPoint.NORTH);
        InitialProperties.setAxisRangeX(5);
        InitialProperties.setAxisRangeY(5);
        InitialProperties.setSouthLimit(0);
        InitialProperties.setNorthLimit(5);
        InitialProperties.setWestLimit(0);
        InitialProperties.setEastLimit(5);
        InitialProperties.setLocale(new Locale("pt_BR"));
    }

    private void mockRobotFactory() {
        Position position = new Position(
                InitialProperties.COORDINATE_X,
                InitialProperties.COORDINATE_Y,
                InitialProperties.DIRECTION);
        robot = new Robot(position);

        when(robotFactory.create()).thenReturn(robot);
    }

    private void setPositionService() {
        positionService = new PositionService();
        positionService.setMessagesProperties(messagesProperties);
        robotService.setPositionService(positionService);
    }

    private void mockMessagesProperties() {
        when(messagesProperties.getMessage("error.position_not_valid"))
                .thenReturn("position_not_valid");
    }

    private void mockReturnParse(String route, List<ActionStrategy> actions) {
        when(actionParse.parse(route))
                .thenReturn(actions);
    }
}