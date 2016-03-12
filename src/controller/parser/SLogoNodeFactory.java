package controller.parser;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import controller.commands.AbstractExpressionNode;
import controller.commands.ConstantNode;
import controller.commands.GroupEndNode;
import controller.commands.GroupNode;
import controller.commands.ListEndNode;
import controller.commands.ListNode;
import controller.commands.UserCommandNode;
import controller.commands.VariableNode;
import javafx.beans.property.MapProperty;


/**
 * Factory for all command nodes that uses regex to determine type
 *
 * @author David Maydew
 *
 */
public class SLogoNodeFactory {

    private static final String COMMAND_PACKAGE = "controller.commands.";
    private static final String LANGUAGE_PACKAGE = "resources.languages.";
    private ResourceBundle myErrorResources =
            ResourceBundle.getBundle("resources.languages.Errors");
    private static final String NO_MATCH = "NO MATCH";

    private Map<String, Pattern> myTypePatterns;
    private String myCurrentLanguage;
    private Map<String, Pattern> myCommandPatterns;

    /**
     * Creates a new factory with specified patterns
     *
     * @param patternMap syntax patterns
     */
    public SLogoNodeFactory (Map<String, Pattern> patternMap) {
        setTypePatternMap(patternMap);
    }

    /**
     * returns the node for a given key, language, and set of user commands
     *
     * @param token key of node to be parsed
     * @param currentLanguage
     * @param commandsProperty user defined commands
     * @return Root node for this tree
     * @throws ParsingException
     */
    public AbstractExpressionNode createNode (String token,
                                              String currentLanguage,
                                              MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        if (getTypePattern("Constant").matcher(token).matches()) {
            return createConstantNode(token);
        }
        else if (getTypePattern("Variable").matcher(token).matches()) {
            return createVariableNode(token);
        }
        else if (getTypePattern("Command").matcher(token).matches()) {
            return createCommandNode(token, currentLanguage, commandsProperty);
        }
        else if (getTypePattern("ListStart").matcher(token).matches()) {
            return createListStart(token);
        }
        else if (getTypePattern("ListEnd").matcher(token).matches()) {
            return createListEnd(token);
        }
        else if (getTypePattern("GroupStart").matcher(token).matches()) {
            return createGroupStart(token);
        }
        else if (getTypePattern("GroupEnd").matcher(token).matches()) {
            return createGroupEnd(token);
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

    private AbstractExpressionNode createGroupStart (String token) {
        return new GroupNode(token);
    }

    private AbstractExpressionNode createGroupEnd (String token) {
        return new GroupEndNode(token);
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

    /**
     * Update language to current patterns in a resource bundle
     *
     * @param newLanguage
     */
    private void loadNewLanguage (String newLanguage) {
        ResourceBundle newBundle = ResourceBundle.getBundle(LANGUAGE_PACKAGE + newLanguage);
        Enumeration<String> iter = newBundle.getKeys();
        Map<String, Pattern> newPatterns = new LinkedHashMap<String, Pattern>();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = newBundle.getString(key);
            newPatterns.put(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE));
        }
        addDefine(newPatterns);
        setCommandPatterns(newPatterns);
        setCurrentLanguage(newLanguage);
    }

    private void addDefine (Map<String, Pattern> newPatterns) {
        newPatterns.put("Define", Pattern.compile("define", Pattern.CASE_INSENSITIVE));
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
