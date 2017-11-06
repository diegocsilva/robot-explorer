package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.model.Position;

public interface ActionStrategy {
    void execute(Position position);
}
