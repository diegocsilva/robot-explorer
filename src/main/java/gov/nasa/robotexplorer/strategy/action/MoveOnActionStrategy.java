package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.exception.AxisDoesNotValidException;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisXStrategy;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisYStrategy;

public class MoveOnActionStrategy implements ActionStrategy{
    @Override
    public Position execute(Position position) throws AxisDoesNotValidException {
        switch (position.getDirection().getAxisWhereMove()){
            case AXIS_X:
                return new MoveInAxisXStrategy().move(position);
            case AXIS_Y:
                return new MoveInAxisYStrategy().move(position);
            default:
                throw new AxisDoesNotValidException();
        }

    }
}
