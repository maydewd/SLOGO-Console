package controller.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import controller.commands.AbstractExpressionNode;
import model.BasicModelActions;


public class SLogoParser {
    private SLogoNodeFactory myNodeFactory;

    private ResourceBundle myPatternResources =
            ResourceBundle.getBundle("resources.languages.Syntax");
    private Map<String, Pattern> myPatternMap;

    public SLogoParser () {
        initializePatternMap();
        setNodeFactory(new SLogoNodeFactory(getPatternMap()));
    }

    private void initializePatternMap () {
        Map<String, Pattern> patternMap = new HashMap<String, Pattern>();
        for (String key : myPatternResources.keySet()) {
            patternMap.put(key, Pattern.compile(myPatternResources.getString(key),
                                                Pattern.CASE_INSENSITIVE));
        }
        setPatternMap(patternMap);
    }

    public List<AbstractExpressionNode> parse (String inputString, ResourceBundle languageBundle) throws ParsingException {
        String commentsRemoved = removeComments(inputString);
        Queue<String> tokens = getTokens(commentsRemoved);
        List<AbstractExpressionNode> allRoots = new LinkedList<AbstractExpressionNode>();
        while (!tokens.isEmpty()) {
            AbstractExpressionNode root = parseHelper(tokens, languageBundle);
            allRoots.add(root);
        }
        return allRoots;
    }

    private AbstractExpressionNode parseHelper (Queue<String> tokens, ResourceBundle languageBundle) throws ParsingException {
        AbstractExpressionNode node = getNodeFactory().createNode(tokens.poll(), languageBundle);
        while (!node.areParametersComplete()) {
            if (tokens.isEmpty()) {
                // TODO add message that additional parameters are expected
                throw new ParsingException();
            }
            node.addParameter(parseHelper(tokens, languageBundle));
        }
        return node;
    }

    private Queue<String> getTokens (String inputString) {
        return new LinkedList<String>(Arrays.asList(inputString.split("\\s+")));
    }

    private String removeComments (String inputString) {
        Pattern commentPattern = getPatternMap().get("Comment");
        String commentsRemoved = commentPattern.matcher(inputString).replaceAll("");
        return commentsRemoved;
    }

    private SLogoNodeFactory getNodeFactory () {
        return myNodeFactory;
    }

    private void setNodeFactory (SLogoNodeFactory nodeFactory) {
        myNodeFactory = nodeFactory;
    }

    private Map<String, Pattern> getPatternMap () {
        return myPatternMap;
    }

    private void setPatternMap (Map<String, Pattern> patternMap) {
        myPatternMap = patternMap;
    }

    /**
     * Testing
     */
    public static void main (String[] args) throws ParsingException {
        IBasicSLogoCommands commands = null;
        SLogoParser test = new SLogoParser();
        test.parse("Forward 50", ResourceBundle.getBundle("resources.languages.English"));
    }
}
