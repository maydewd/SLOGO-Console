package controller.parser;

import java.util.Collection;
import java.util.List;

public interface IAdvancedSLogoCommands extends IBasicSLogoCommands {
    
        public List<Integer> getSelectedTurtles ();
	
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

}
