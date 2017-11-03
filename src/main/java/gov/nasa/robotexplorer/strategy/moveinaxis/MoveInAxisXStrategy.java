package gov.nasa.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.model.Position;

public class MoveInAxisXStrategy implements MoveInAxisStrategy{
    @Override
    public Position move(Position position) {
        Integer coordinate = position.getCoordinateX() + position.getDirection().getValueDeslocationInAxis();
        position.setCoordinateX(coordinate);
        return position;
    }
}
