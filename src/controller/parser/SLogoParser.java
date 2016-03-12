package controller.parser;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.MapProperty;


/**
 * Parser for SLogo commands that
 *
 * @author David Maydew
 *
 */
public class SLogoParser {
    private SLogoNodeFactory myNodeFactory;

    private ResourceBundle mySyntaxResources =
            ResourceBundle.getBundle("resources.languages.Syntax");
    private ResourceBundle myErrorResources =
            ResourceBundle.getBundle("resources.languages.Errors");
    private Map<String, Pattern> mySyntaxPatterns;

    public SLogoParser () {
        initializePatternMap();
        setNodeFactory(new SLogoNodeFactory(getSyntaxPatterns()));
    }

    private void initializePatternMap () {
        Map<String, Pattern> patternMap = new LinkedHashMap<String, Pattern>();
        for (String key : getSyntaxResources().keySet()) {
            patternMap.put(key, Pattern.compile(getSyntaxResources().getString(key).trim(),
                                                Pattern.CASE_INSENSITIVE));
        }
        setPatternMap(patternMap);
    }

    public List<AbstractExpressionNode> parse (String inputString,
                                               String currentLanguage,
                                               MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        Queue<String> tokens = getValidTokens(inputString);
        List<AbstractExpressionNode> allRoots = new LinkedList<AbstractExpressionNode>();
        while (!tokens.isEmpty()) {
            AbstractExpressionNode root = parseHelper(tokens, currentLanguage, commandsProperty);
            allRoots.add(root);
        }
        return allRoots;
    }

    private AbstractExpressionNode parseHelper (Queue<String> tokens,
                                                String currentLanguage,
                                                MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        AbstractExpressionNode node =
                getNodeFactory().createNode(tokens.poll(), currentLanguage, commandsProperty);
        while (!node.areParametersComplete()) {
            if (tokens.isEmpty()) {
                String errorMessage = myErrorResources.getString("MoreTokensExpected");
                throw new ParsingException(errorMessage);
            }
            node.addParameter(parseHelper(tokens, currentLanguage, commandsProperty));
        }
        return node;
    }

    private Queue<String> getValidTokens (String inputString) {
        Queue<String> validTokens = new LinkedList<>();
        Pattern commentPattern = getSyntaxPatterns().get("Comment");
        String[] lines = inputString.split("\\r?\\n");
        for (String line : lines) {
            if (line.trim().length() > 0 && !commentPattern.matcher(line).matches()) {
                validTokens.addAll(Arrays.asList(line.trim().split("\\s+")));
            }
        }
        return validTokens;
    }

    private SLogoNodeFactory getNodeFactory () {
        return myNodeFactory;
    }

    private void setNodeFactory (SLogoNodeFactory nodeFactory) {
        myNodeFactory = nodeFactory;
    }

    private ResourceBundle getSyntaxResources () {
        return mySyntaxResources;
    }

    private Map<String, Pattern> getSyntaxPatterns () {
        return mySyntaxPatterns;
    }

    private void setPatternMap (Map<String, Pattern> patternMap) {
        mySyntaxPatterns = patternMap;
    }

}
