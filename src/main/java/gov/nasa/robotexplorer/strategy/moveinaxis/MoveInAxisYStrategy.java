package gov.nasa.robotexplorer.strategy.moveinaxis;

import gov.nasa.robotexplorer.model.Position;

public class MoveInAxisYStrategy implements MoveInAxisStrategy{
    @Override
    public Position move(Position position) {
        Integer coordinate = position.getCoordinateY() + position.getDirection().getValueDeslocationInAxis();
        position.setCoordinateY(coordinate);
        return position;
    }
}
