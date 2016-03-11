package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.ReadOnlyListProperty;


public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {

	private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
	private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();
	
	public SLogoAdvancedModel () {
	    setMyTurtleModel(myTurtleModel);
	    setMyOptionsModel(myOptionsModel);
	}


	private AdvancedTurtleModel getMyTurtleModel () {
		return myTurtleModel;
	}

	public AdvancedOptionsModel getMyOptionsModel () {
		return myOptionsModel;
	}

	@Override
	public void addSelectedTurtle (int IDnumber) {
		getMyTurtleModel().selectTurtle(IDnumber);
	}

	@Override
	public void clearSelectedTurtles () {
		getMyTurtleModel().selectedTurtlesProperty().clear();
	}
	
	@Override
	    public List<Integer> getSelectedTurtleIDs () {
	        return new ArrayList<Integer>(getMyTurtleModel().selectedTurtlesProperty());
	    }

	@Override
	public List<Double> getLineThicknesses () {
		return getMyOptionsModel().lineThicknessOptionsProperty().get();
	}

	@Override
	public List<Entry<Double, Double>> getLineTypeValues () {
		return getMyOptionsModel().lineTypeOptionsProperty().get();
	}

	@Override
	public void drawStamp () {
		getMyTurtleModel().drawStamp();

	}

	@Override
	public void clearStamps () {
		getMyTurtleModel().stampsProperty().clear();
	}

	@Override
	public int getActiveTurtleID () {
		return getMyTurtleModel().getActiveTurtle().getID();
	}

	@Override
	public void setLineThickness (int i) {
		getMyTurtleModel().setSelectedLineThickness(i);
	}

	@Override
	public void setLineType (int i) {
		getMyTurtleModel().setSelectedLineType(getMyOptionsModel().lineTypeOptionsProperty().get(i));     
	}

	@Override
	public ReadOnlyListProperty<StampInfo> getStamps () {
		return getMyTurtleModel().stampsProperty();
	}

	@Override
	public Collection<? extends TurtleInfo> getAllTurtleInfo() {
		return getMyTurtleModel().allTurtlesProperty().values();
	}

	@Override
	public TurtleInfo getTurtle(int id) {
		return getMyTurtleModel().allTurtlesProperty().get(id);
	}

    @Override
    public List<Integer> getAllTurtleIDs () {
        return new ArrayList<Integer>(getMyTurtleModel().allTurtlesProperty().keySet());
    }
    
    


    


}

