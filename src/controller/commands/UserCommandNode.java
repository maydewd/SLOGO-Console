package controller.commands;

import java.util.List;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class UserCommandNode extends SimpleProcedureNode {

    public UserCommandNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        List<String> parameters = commands.getUserMethodParams(getText());
        for (int i=0; i < parameters.size(); i++) {
            commands.setVariable(parameters.get(i), getChildren().get(i).execute(commands));
        }
        // TODO add check to verify that the function exists!
        return commands.getUserMethodBody(getText()).execute(commands);
    }



}
