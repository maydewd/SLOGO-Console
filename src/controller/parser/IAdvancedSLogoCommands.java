package controller.parser;

import java.util.List;

import controller.commands.AbstractExpressionNode;

public interface IAdvancedSLogoCommands extends IBasicSLogoCommands {
	
	public double setBackground (int index);
	
	public double setPenColor (int index);
	
	public double setPenSize (int pixels);
	
	public double setShape (int index);
	
	public double setPalette (int index, int r, int g, int b);
	
	public double getPenColor ();
	
	public double getShape ();
	
	public double stamp ();
	
	public double clearStamps ();
	
	public double getCurrentActiveID ();
	
	public double getTurtleCount ();
	
	public double tell (List<Integer> ids);
	
	public double ask (List<Integer> ids, List<AbstractExpressionNode> commands);
	
	public double askWith ();
}
