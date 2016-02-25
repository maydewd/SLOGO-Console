package controller.parser;

import java.util.Map;
import java.util.regex.Pattern;
import controller.commands.AbstractExpressionNode;
import controller.commands.ConstantNode;
import controller.commands.ListEndNode;
import controller.commands.ListNode;
import controller.commands.VariableNode;
import model.BasicModelActions;


public class SLogoNodeFactory {

    private Map<String, Pattern> myPatternMap;

    public SLogoNodeFactory (BasicModelActions modelActions, Map<String, Pattern> patternMap) {
        // TODO implement multi-language functionality
        setPatternMap(patternMap);
    }

    public AbstractExpressionNode createNode (String token) throws ParsingException {
        if (getPattern("Constant").matcher(token).find()) {
            return createConstantNode(token);
        }
        else if (getPattern("Variable").matcher(token).find()) {
            return createVariableNode(token);
        }
        else if (getPattern("Command").matcher(token).find()) {
            return createCommandNode(token);
        }
        else if (getPattern("ListStart").matcher(token).find()) {
            return createListStart(token);
        }
        else if (getPattern("ListEnd").matcher(token).find()) {
            return createListEnd(token);
        }
        else {
            // TODO throw new Exception();
        }
        return null;
    }

    private AbstractExpressionNode createConstantNode (String token) {
        return new ConstantNode(token);
    }

    private AbstractExpressionNode createVariableNode (String token) {
        return new VariableNode(token);
    }

    private AbstractExpressionNode createCommandNode (String token) throws ParsingException {
        String functionName = getTranslatedName(token);
        if (functionName != null) {
            try {
                return (AbstractExpressionNode) Class.forName(functionName).newInstance();
            }
            catch (ReflectiveOperationException e) {
                // TODO add message
                throw new ParsingException();
            }
        }
        else {
            // return new UserDefinedCommand();
        }
        return null;
    }

    private AbstractExpressionNode createListStart (String token) {
        return new ListNode(token);
    }

    private AbstractExpressionNode createListEnd (String token) {
        return new ListEndNode(token);
    }

    private String getTranslatedName (String token) {
        // TODO get translated name
        return null;
    }

    private Pattern getPattern (String key) {
        return getPatternMap().get(key);
    }

    private Map<String, Pattern> getPatternMap () {
        return myPatternMap;
    }

    private void setPatternMap (Map<String, Pattern> patternMap) {
        myPatternMap = patternMap;
    }
}
