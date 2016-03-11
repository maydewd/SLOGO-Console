package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;
import java.util.List;


public class UserCommandNode extends SimpleProcedureNode {

    public UserCommandNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        if (commands.getUserMethodBody(getText()) == null) {
            String errorMessage = String.format(getErrorMessage("NoFunctionExists"), getText());
            throw new ParsingException(errorMessage);
        }
        List<String> parameters = commands.getUserMethodParams(getText());
        for (int i = 0; i < parameters.size(); i++) {
            commands.setVariable(parameters.get(i), getChildren().get(i).execute(commands));
        }
        return commands.getUserMethodBody(getText()).execute(commands);
    }

}
