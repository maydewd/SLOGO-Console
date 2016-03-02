package controller.parser;

import controller.commands.AbstractExpressionNode;
import javafx.beans.property.MapProperty;

import java.util.*;
import java.util.regex.Pattern;

import java.util.*;
import java.util.regex.Pattern;


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
            patternMap.put(key, Pattern.compile(getSyntaxResources().getString(key),
                                                Pattern.CASE_INSENSITIVE));
        }
        setPatternMap(patternMap);
    }

    public List<AbstractExpressionNode> parse (String inputString,
                                               String currentLanguage,
                                               MapProperty<String, List<String>> commandsProperty) throws ParsingException {
        String commentsRemoved = removeComments(inputString);
        Queue<String> tokens = getTokens(commentsRemoved);
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
        AbstractExpressionNode node = getNodeFactory().createNode(tokens.poll(), currentLanguage, commandsProperty);
        while (!node.areParametersComplete()) {
            if (tokens.isEmpty()) {
                String errorMessage = myErrorResources.getString("MoreTokensExpected");
                throw new ParsingException(errorMessage);
            }
            node.addParameter(parseHelper(tokens, currentLanguage, commandsProperty));
        }
        return node;
    }

    private Queue<String> getTokens (String inputString) {
        return new LinkedList<String>(Arrays.asList(inputString.split("\\s+")));
    }

    private String removeComments (String inputString) {
        Pattern commentPattern = getSyntaxPatterns().get("Comment");
        String commentsRemoved = commentPattern.matcher(inputString).replaceAll("");
        return commentsRemoved;
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
