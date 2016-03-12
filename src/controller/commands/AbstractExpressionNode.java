package controller.commands;

import java.util.List;
import java.util.ResourceBundle;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


/**
 * Basic representation for a command node in the SLogo engine. Handles parameters and execution
 * given an interpreter.
 *
 * @author David Maydew
 *
 */
public abstract class AbstractExpressionNode {

    private ResourceBundle myErrorResources =
            ResourceBundle.getBundle("resources.languages.Errors");

    private String myText;

    private SyntaxType myType;

    public AbstractExpressionNode (String text, SyntaxType type) {
        setText(text);
        setType(type);
    }

    /**
     * recursively execute this node and its children
     *
     * @param commands advanced interpreter
     * @return value returned by this node
     * @throws ParsingException
     */
    public abstract double execute (IAdvancedSLogoCommands commands) throws ParsingException;

    /**
     * @return true if the necessary parameters for this node have been added
     */
    public abstract boolean areParametersComplete ();

    /**
     * adds a parameter to this node as a child
     *
     * @param node child parameter to add
     * @throws ParsingException
     */
    public abstract void addParameter (AbstractExpressionNode node) throws ParsingException;

    protected String getErrorMessage (String errorName) {
        return getErrorResources().getString(errorName);
    }

    private ResourceBundle getErrorResources () {
        return myErrorResources;
    }

    /**
     * @return the token that triggered the creation of this noe
     */
    public String getText () {
        return myText;
    }

    private void setText (String text) {
        myText = text;
    }

    /**
     * @return the syntax type of this node
     */
    public SyntaxType getType () {
        return myType;
    }

    private void setType (SyntaxType type) {
        myType = type;
    }

    protected abstract List<AbstractExpressionNode> getChildren () throws ParsingException;

    /**
     * The string representation of this node.
     */
    @Override
    public String toString () {
        return getText() + " ";
    }

}
