package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.model.Position;

public class TurnRightActionStrategy implements ActionStrategy{
    @Override
    public Position execute(Position position) {
        position.setDirection(position.getDirection().getTurnRight());
        return position;
    }
}
