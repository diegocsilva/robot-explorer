package gov.nasa.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.model.Position;

public class MoveInAxisXStrategy implements MoveInAxisStrategy{
    @Override
    public Position move(Position position) {
        position.setCoordinateX(
                position.getCoordinateX() + position.getDirection().getValueDeslocationInAxis()
        );
        return position;
    }
}
