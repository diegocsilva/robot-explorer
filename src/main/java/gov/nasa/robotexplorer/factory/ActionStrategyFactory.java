package gov.nasa.robotexplorer.factory;

import gov.nasa.robotexplorer.exception.ActionDoesNotValidException;
import gov.nasa.robotexplorer.helper.MessageSourceHelper;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import gov.nasa.robotexplorer.strategy.action.MoveOnActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnLeftActionStrategy;
import gov.nasa.robotexplorer.strategy.action.TurnRightActionStrategy;

public enum ActionStrategyFactory {
    TO_TURN_RIGHT("R") {
        @Override
        public ActionStrategy getAction() {
            return new TurnRightActionStrategy();
        }
    },
    TO_TURN_LEFT("L") {
        @Override
        public ActionStrategy getAction() {
            return new TurnLeftActionStrategy();
        }
    },
    MOVE_ON("M") {
        @Override
        public ActionStrategy getAction() {
            return new MoveOnActionStrategy();
        }
    };

    private String code;

    public abstract ActionStrategy getAction();

    ActionStrategyFactory(String code) {
        this.code = code;
    }

    public static ActionStrategyFactory getByCode(char code){
        switch (code) {
            case 'R':  return TO_TURN_RIGHT;
            case 'L':  return TO_TURN_LEFT;
            case 'M':  return MOVE_ON;
            default:
                throw new ActionDoesNotValidException(MessageSourceHelper.getMessage("error.action_not_valid"));
        }
    }


    public String getCode() {
        return code;
    }
}
