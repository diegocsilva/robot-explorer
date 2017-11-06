package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.domain.CardinalPoint;
import gov.nasa.robotexplorer.model.Position;

public class TurnLeftActionStrategy extends ActionStrategyImpl {
    @Override
    public void execute(Position position) {
        CardinalPoint direction = position.getDirection().getTurnLeft();
        position.setDirection(direction);
    }
}
