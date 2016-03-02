package controller.parser;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import controller.commands.*;
import javafx.beans.property.MapProperty;


public class SLogoNodeFactory {

    private static final String COMMAND_PACKAGE = "controller.commands.";
    private static final String LANGUAGE_PACKAGE = "resources.languages.";
    private ResourceBundle myErrorResources =
            ResourceBundle.getBundle("resources.languages.Errors");
    private static final String NO_MATCH = "NO MATCH";

    private Map<String, Pattern> myTypePatterns;
    private String myCurrentLanguage;
    private Map<String, Pattern> myCommandPatterns;

    public SLogoNodeFactory (Map<String, Pattern> patternMap) {
        setTypePatternMap(patternMap);
    }

    public AbstractExpressionNode createNode (String token,
                                              String currentLanguage,
                                              MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        if (getTypePattern("Constant").matcher(token).find()) {
            return createConstantNode(token);
        }
        else if (getTypePattern("Variable").matcher(token).find()) {
            return createVariableNode(token);
        }
        else if (getTypePattern("Command").matcher(token).find()) {
            return createCommandNode(token, currentLanguage, commandsProperty);
        }
        else if (getTypePattern("ListStart").matcher(token).find()) {
            return createListStart(token);
        }
        else if (getTypePattern("ListEnd").matcher(token).find()) {
            return createListEnd(token);
        }
        else {
            String errorMessage =
                    String.format(myErrorResources.getString("NoPatternMatch"), token);
            throw new ParsingException(errorMessage);
        }
    }

    private AbstractExpressionNode createConstantNode (String token) {
        return new ConstantNode(token);
    }

    private AbstractExpressionNode createVariableNode (String token) {
        return new VariableNode(token);
    }

    private AbstractExpressionNode createCommandNode (String token,
                                                      String currentLanguage,
                                                      MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        String functionName = getTranslatedName(token, currentLanguage);
        if (functionName != NO_MATCH) {
            try {
                Constructor<?> nodeConstructor =
                        Class.forName(COMMAND_PACKAGE + functionName + "Node")
                                .getConstructor(String.class);
                return (AbstractExpressionNode) nodeConstructor.newInstance(token);
            }
            catch (ReflectiveOperationException e) {
                String errorMessage =
                        String.format(myErrorResources.getString("ReflectiveCommandError"), token);
                throw new ParsingException(errorMessage);
            }
        }
        else {
            int numDefinedParameters =
                    commandsProperty.containsKey(token) ? commandsProperty.get(token).size() : 0;
            return new UserCommandNode(token, numDefinedParameters);
        }
    }

    private AbstractExpressionNode createListStart (String token) {
        return new ListNode(token);
    }

    private AbstractExpressionNode createListEnd (String token) {
        return new ListEndNode(token);
    }

    private String getTranslatedName (String token, String currentLocale) {
        if (!currentLocale.equals(getCurrentLanguage())) {
            loadNewLanguage(currentLocale);
        }
        for (Entry<String, Pattern> entry : getCommandPatterns().entrySet()) {
            if (entry.getValue().matcher(token).matches()) {
                return entry.getKey();
            }
        }
        return NO_MATCH;
    }

    private void loadNewLanguage (String newLanguage) {
        ResourceBundle newBundle = ResourceBundle.getBundle(LANGUAGE_PACKAGE + newLanguage);
        Enumeration<String> iter = newBundle.getKeys();
        Map<String, Pattern> newPatterns = new LinkedHashMap<String, Pattern>();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = newBundle.getString(key);
            newPatterns.put(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE));
        }
        setCommandPatterns(newPatterns);
        setCurrentLanguage(newLanguage);
    }

    private Pattern getTypePattern (String key) {
        return getTypePatternMap().get(key);
    }

    private Map<String, Pattern> getTypePatternMap () {
        return myTypePatterns;
    }

    private void setTypePatternMap (Map<String, Pattern> patternMap) {
        myTypePatterns = patternMap;
    }

    private String getCurrentLanguage () {
        return myCurrentLanguage;
    }

    private void setCurrentLanguage (String newLanguage) {
        myCurrentLanguage = newLanguage;
    }

    private Map<String, Pattern> getCommandPatterns () {
        return myCommandPatterns;
    }

    private void setCommandPatterns (Map<String, Pattern> newPatterns) {
        myCommandPatterns = newPatterns;
    }
}
