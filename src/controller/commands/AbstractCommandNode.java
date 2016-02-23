package controller.commands;

public abstract class AbstractCommandNode {

    public AbstractCommandNode () {
    }
    
    public abstract void execute();
    public abstract AbstractCommandNode parseChildren(StringBuffer remainingCommand);
    
    protected abstract double getValue();
    

}
