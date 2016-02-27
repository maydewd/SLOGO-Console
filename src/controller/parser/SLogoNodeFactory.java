package controller.parser;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import controller.commands.*;
import model.BasicModelActions;


public class SLogoNodeFactory {

    private static final String COMMAND_PACKAGE = "controller.commands.";

    private Map<String, Pattern> myPatternMap;
    private ResourceBundle myCurrentLanguageBundle;

    public SLogoNodeFactory (Map<String, Pattern> patternMap) {
        // TODO implement multi-language functionality

        setPatternMap(patternMap);
    }

    public AbstractExpressionNode createNode (String token, ResourceBundle languageBundle) throws ParsingException {
        if (getPattern("Constant").matcher(token).find()) {
            return createConstantNode(token);
        }
        else if (getPattern("Variable").matcher(token).find()) {
            return createVariableNode(token);
        }
        else if (getPattern("Command").matcher(token).find()) {
            return createCommandNode(token, languageBundle);
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

    private AbstractExpressionNode createCommandNode (String token, ResourceBundle languageBundle) throws ParsingException {
        String functionName = getTranslatedName(token, languageBundle);
        if (functionName != null) {
            try {
                Constructor<?> nodeConstructor =
                        Class.forName(COMMAND_PACKAGE + functionName + "Node")
                                .getConstructor(String.class);
                return (AbstractExpressionNode) nodeConstructor.newInstance(token);
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

    private String getTranslatedName (String token, ResourceBundle languageBundle) {
        // TODO get translated name
        
        return token;
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

    public ResourceBundle getCurrentLanguageBundle () {
        return myCurrentLanguageBundle;
    }

    public void setCurrentLanguageBundle (ResourceBundle currentLanguageBundle) {
        myCurrentLanguageBundle = currentLanguageBundle;
    }
}
