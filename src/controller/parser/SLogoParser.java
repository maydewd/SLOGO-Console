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
            ResourceBundle.getBundle("resources.languages/Syntax.properties");
    private Map<String, Pattern> myPatternMap;

    public SLogoParser (BasicModelActions modelActions) {
        setNodeFactory(new SLogoNodeFactory(modelActions, getPatternMap()));
        initializePatternMap();
    }

    private void initializePatternMap () {
        Map<String, Pattern> patternMap = new HashMap<String, Pattern>();
        for (String key : myPatternResources.keySet()) {
            patternMap.put(key, Pattern.compile(myPatternResources.getString(key),
                                                Pattern.CASE_INSENSITIVE));
        }
        setPatternMap(patternMap);
    }

    public List<AbstractExpressionNode> parse (String inputString) throws ParsingException {
        String commentsRemoved = removeComments(inputString);
        Queue<String> tokens = getTokens(commentsRemoved);
        List<AbstractExpressionNode> allRoots = new LinkedList<AbstractExpressionNode>();
        while (!tokens.isEmpty()) {
            AbstractExpressionNode root = parseHelper(tokens);
            allRoots.add(root);
        }
        return allRoots;
    }

    private AbstractExpressionNode parseHelper (Queue<String> tokens) throws ParsingException {
        AbstractExpressionNode node = getNodeFactory().createNode(tokens.poll());
        while (!node.areParametersComplete()) {
            if (tokens.isEmpty()) {
                // TODO add message that additional parameters are expected
                throw new ParsingException();
            }
            node.addParameter(parseHelper(tokens));
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
}
