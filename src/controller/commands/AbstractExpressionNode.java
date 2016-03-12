package controller.commands;

import java.util.List;
import java.util.ResourceBundle;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public abstract class AbstractExpressionNode {

    private ResourceBundle myErrorResources =
            ResourceBundle.getBundle("resources.languages.Errors");

    private String myText;

    private SyntaxType myType;

    public AbstractExpressionNode (String text, SyntaxType type) {
        setText(text);
        setType(type);
    }

    public abstract double execute (IAdvancedSLogoCommands commands) throws ParsingException;

    public abstract boolean areParametersComplete ();

    public abstract void addParameter (AbstractExpressionNode node) throws ParsingException;

    protected String getErrorMessage (String errorName) {
        return getErrorResources().getString(errorName);
    }

    private ResourceBundle getErrorResources () {
        return myErrorResources;
    }

    public String getText () {
        return myText;
    }

    private void setText (String text) {
        myText = text;
    }

    public SyntaxType getType () {
        return myType;
    }

    private void setType (SyntaxType type) {
        myType = type;
    }
    
    protected abstract List<AbstractExpressionNode> getChildren() throws ParsingException;
    
    @Override
    public String toString() {
        return getText() + " ";
    }

}
