package controller.parser;

import controller.commands.AbstractExpressionNode;

import java.util.*;
import java.util.regex.Pattern;


public class SLogoParser {
    private SLogoNodeFactory myNodeFactory;

    private ResourceBundle mySyntaxResources =
            ResourceBundle.getBundle("resources.languages.Syntax");
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

    public List<AbstractExpressionNode> parse (String inputString, String currentLanguage) throws ParsingException {
        String commentsRemoved = removeComments(inputString);
        Queue<String> tokens = getTokens(commentsRemoved);
        List<AbstractExpressionNode> allRoots = new LinkedList<AbstractExpressionNode>();
        while (!tokens.isEmpty()) {
            AbstractExpressionNode root = parseHelper(tokens, currentLanguage);
            allRoots.add(root);
        }
        return allRoots;
    }

    private AbstractExpressionNode parseHelper (Queue<String> tokens, String currentLanguage) throws ParsingException {
        AbstractExpressionNode node = getNodeFactory().createNode(tokens.poll(), currentLanguage);
        while (!node.areParametersComplete()) {
            if (tokens.isEmpty()) {
                // TODO add message that additional parameters are expected
                throw new ParsingException();
            }
            node.addParameter(parseHelper(tokens, currentLanguage));
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
    
    private ResourceBundle getSyntaxResources() {
        return mySyntaxResources;
    }

    private Map<String, Pattern> getSyntaxPatterns () {
        return mySyntaxPatterns;
    }

    private void setPatternMap (Map<String, Pattern> patternMap) {
        mySyntaxPatterns = patternMap;
    }

    /**
     * Testing
     */
    public static void main (String[] args) throws ParsingException {
        SLogoParser test = new SLogoParser();
        test.parse("Forward 50", "ENGLISH");
    }
}
