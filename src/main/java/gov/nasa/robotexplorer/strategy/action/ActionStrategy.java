package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.exception.AxisDoesNotValidException;
import gov.nasa.robotexplorer.model.Position;

public interface ActionStrategy {
    Position execute(Position position) throws AxisDoesNotValidException;
}
