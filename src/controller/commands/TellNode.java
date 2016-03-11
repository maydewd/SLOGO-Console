package controller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class TellNode extends ControlProcedureNode {

    private static final int TELL_NUM_PARAMS = 1;

    public TellNode (String text) {
        super(text, TELL_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("InvalidParameter"),
                                     getText(), SyntaxType.LISTSTART);
        if (!isList(node)) {
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        List<AbstractExpressionNode> turtles = getChildren().get(0).getChildren();
        List<Integer> turtleIDs = new ArrayList<>();
        for (AbstractExpressionNode turtle : turtles) {
            turtleIDs.add((int) turtle.execute(commands));
        }
        return commands.tellAll(turtleIDs);
    }

}
