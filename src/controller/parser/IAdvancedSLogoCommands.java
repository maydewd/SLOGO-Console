package controller.parser;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IAdvancedSLogoCommands extends IBasicSLogoCommands {
    
        public List<Integer> getSelectedTurtles ();
        
        public List<Integer> getAllTurtles ();
	
	public double setBackground (int index);
	
	public double setPenColor (int index);
	
	public double setPenSize (double pixels);
	
	public double setShape (int index);
	
	public double setPalette (int index, int r, int g, int b);
	
	public double getPenColor ();
	
	public double getShape ();
	
	public double stamp ();
	
	public double clearStamps ();

	public double getCurrentActiveID ();
	
	public double getTurtleCount ();
	
	public double tell (Integer id);
	
	public double tellAll (List<Integer> ids);

    double defineCommand (String name, List<String> params);
    
    Map<String, Double> getAllVariables();
    
    void setAllVariables (Map<String, Double> allVars);

}
