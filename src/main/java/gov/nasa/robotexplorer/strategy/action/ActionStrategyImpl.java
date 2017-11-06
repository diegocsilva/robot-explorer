package gov.nasa.robotexplorer.strategy.action;

public abstract class ActionStrategyImpl implements ActionStrategy {
    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }
}
