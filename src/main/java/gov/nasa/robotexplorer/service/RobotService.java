package gov.nasa.robotexplorer.service;

import gov.nasa.robotexplorer.factory.RobotFactory;
import gov.nasa.robotexplorer.model.Robot;
import gov.nasa.robotexplorer.parse.ActionParse;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    private RobotFactory robotFactory;

    private ActionParse actionParse;

    private PositionService positionService;

    public Robot executeTheRoute(String route) {
        List<ActionStrategy> actions = actionParse.parse(route);
        Robot robot = robotFactory.create();

        actions.stream().forEach(action ->
                action.execute(robot.getPosition()));

        positionService.validPosition(robot.getPosition());

        return robot;
    }

    @Autowired
    public void setRobotFactory(RobotFactory robotFactory) {
        this.robotFactory = robotFactory;
    }

    @Autowired
    public void setActionParse(ActionParse actionParse) {
        this.actionParse = actionParse;
    }

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
