package controller.commands;

import java.util.List;
import java.util.stream.Collectors;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class DefineNode extends ControlProcedureNode {

    private static final int IF_NUM_PARAMS = 2;

    public DefineNode (String text) {
        super(text, IF_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if ((getChildren().size() == 1) && !isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else if (getChildren().size() == 1 &&
                 !node.getChildren().stream().allMatch(e -> isVariable(e))) {
            String error = String.format(getErrorMessage("InvalidListParameter"),
                                         getText(), SyntaxType.VARIABLE);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        String name = getChildren().get(0).getText();
        List<String> parameters = getChildren().get(1).getChildren().stream()
                .map(node -> node.getText())
                .collect(Collectors.toList());
        return commands.defineCommand(name, parameters);
    }

}
