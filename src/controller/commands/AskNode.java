package controller.commands;

import java.util.ArrayList;
import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class AskNode extends ControlProcedureNode {

    private static final int ASK_NUM_PARAMS = 2;

    public AskNode (String text) {
        super(text, ASK_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (!isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        List<Integer> oldSelected = new ArrayList<>(commands.getSelectedTurtles());
        List<AbstractExpressionNode> turtles = getChildren().get(0).getChildren();
        List<Integer> turtleIDs = new ArrayList<>();
        for (AbstractExpressionNode turtle : turtles) {
            turtleIDs.add((int) turtle.execute(commands));
        }
        commands.tellAll(turtleIDs);
        double retValue = getChildren().get(1).execute(commands);
        commands.tellAll(oldSelected);
        return retValue;
    }

}
