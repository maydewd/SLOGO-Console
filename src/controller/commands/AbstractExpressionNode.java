package controller.commands;

import controller.parser.IBasicSLogoCommands;

public abstract class AbstractExpressionNode {
    
    private String myText;
    
    private SyntaxType myType;

    public AbstractExpressionNode (String text, SyntaxType type) {
        setText(text);
        setType(type);
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
    
    public SyntaxType getType() {
        return myType;
    }
    
    private void setType(SyntaxType type) {
        myType = type;
    }
    

}
