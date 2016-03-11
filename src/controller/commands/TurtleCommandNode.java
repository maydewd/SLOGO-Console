package controller.commands;

import java.util.ArrayList;
import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public abstract class TurtleCommandNode extends SimpleProcedureNode {

    public TurtleCommandNode (String text) {
        super(text);
    }

    public TurtleCommandNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        List<Integer> oldSelected = new ArrayList<>(commands.getSelectedTurtles());
        double lastValue = 0;
        for (Integer id : oldSelected) {
            commands.tell(id);
            lastValue = executeSingle(commands);
        }
        commands.tellAll(oldSelected);
        return lastValue;
    }
    
    protected abstract double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException;

}
