package gov.nasa.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.model.Position;

public class MoveInAxisYStrategy implements MoveInAxisStrategy{
    @Override
    public Position move(Position position) {
        position.setCoordinateY(
                position.getCoordinateY() + position.getDirection().getValueDeslocationInAxis()
        );
        return position;
    }
}
