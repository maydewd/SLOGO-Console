package controller.commands;

import controller.parser.IBasicSLogoCommands;

public abstract class AbstractExpressionNode {
    
    private String myText;

    public AbstractExpressionNode (String text) {
        setText(text);
    }
    
    public abstract AbstractExpressionNode parseChildren(StringBuffer remainingCommand);
    
    public abstract void execute(IBasicSLogoCommands commands);
    
    public abstract boolean areParametersComplete();
    
    public abstract void addParameter(AbstractExpressionNode node);
    
    public String getText() {
        return myText;
    }
    
    private void setText(String text) {
        myText = text;
    }
    

}
