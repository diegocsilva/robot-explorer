package gov.nasa.robotexplorer.parse;

import gov.nasa.robotexplorer.factory.ActionStrategyFactory;
import gov.nasa.robotexplorer.strategy.action.ActionStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActionParse {

    public List<ActionStrategy> parse(String route) {
        List<ActionStrategy> actions = new ArrayList<>();

        route.chars().forEach(command ->
                actions.add(parse((char) command)));

        return actions;
    }

    private ActionStrategy parse(char command) {
        return ActionStrategyFactory.getByCode(command).getAction();
    }


}
