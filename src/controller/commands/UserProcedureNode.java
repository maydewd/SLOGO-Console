package controller.commands;

import java.util.List;
import java.util.stream.Collectors;
import controller.parser.ParsingException;

public abstract class UserProcedureNode extends ControlProcedureNode {

    public UserProcedureNode (String text, int numberParameters) {
        super(text, numberParameters);
    }
    
    protected List<String> collectSecondParamValues() throws ParsingException {
        return getChildren().get(1).getChildren().stream()
                .map(node -> node.getText())
                .collect(Collectors.toList());
    }
    
    protected boolean isNotAllVariables (AbstractExpressionNode node) throws ParsingException {
        return getChildren().size() == 1 &&
                 !node.getChildren().stream().allMatch(e -> isVariable(e));
    }

}
