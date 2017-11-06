package gov.nasa.robotexplorer.strategy.action;

import gov.nasa.robotexplorer.exception.MarsException;
import gov.nasa.robotexplorer.model.Position;
import gov.nasa.robotexplorer.properties.MessagesProperties;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisXStrategy;
import gov.nasa.robotexplorer.strategy.moveinaxis.MoveInAxisYStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class MoveOnActionStrategy extends ActionStrategyImpl {

    @Autowired
    private MessagesProperties messagesProperties;

    @Override
    public void execute(Position position) {
        switch (position.getDirection().getAxisWhereMove()) {
            case AXIS_X:
                new MoveInAxisXStrategy().move(position);
                break;
            case AXIS_Y:
                new MoveInAxisYStrategy().move(position);
                break;
        }

    }
}
