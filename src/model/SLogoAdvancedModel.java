package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.ReadOnlyListProperty;


public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {
<<<<<<< HEAD
    private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
    private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();
    
    public SLogoAdvancedModel () {
        setMyTurtleModel(myTurtleModel);

    }

    public AdvancedTurtleModel getMyTurtleModel () {
        return myTurtleModel;
    }

    public AdvancedOptionsModel getMyOptionsModel () {
        return myOptionsModel;
    }

    @Override
    public void addSelectedTurtles (int IDnumber) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clearSelectedTurtles () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<Integer> getSelectedTurtleIDs () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Double> getLineThicknesses () {
        ArrayList<Double> thicknesses = new ArrayList<>();
        for (LineInfo line: myTurtleModel.getReadOnlyLines()) {
        	thicknesses.add(line.getThickness());
        }
        return thicknesses;
    }


    @Override
    public List<Entry<Double, Double>> getLineTypes () {
    	ArrayList<Entry<Double, Double>> lineTypes = new ArrayList<>();
        for (LineInfo line: myTurtleModel.getReadOnlyLines()) {
        	lineTypes.add(line.getType());
        }
        return lineTypes;
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
    public void setSelectedLineThickness (int i) {
        getMyTurtleModel().setSelectedLineThickness(i);
    }

    @Override
    public void setSelectedLineType (int i) {
        getMyTurtleModel().setSelectedLineType(i);     
    }

    @Override
    public ReadOnlyListProperty<StampInfo> getStamps () {
        return getMyTurtleModel().stampsProperty();
    }
=======
	private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
	private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();

	public SLogoAdvancedModel () {
		TurtleInfo t = myTurtleModel.getActiveTurtle();
		myTurtleModel.allTurtlesProperty().put(t.getID(), t);

	}

	public AdvancedTurtleModel getMyTurtleModel () {
		return myTurtleModel;
	}

	public AdvancedOptionsModel getMyOptionsModel () {
		return myOptionsModel;
	}

	@Override
	public void addSelectedTurtles (int IDnumber) {
		if (getMyTurtleModel().allTurtlesProperty().containsKey(IDnumber)) {
			getMyTurtleModel().selectedTurtlesProperty().put(IDnumber, getMyTurtleModel().getTurtle(IDnumber));
		}
		else {
			Turtle t = new Turtle(IDnumber);
			getMyTurtleModel().allTurtlesProperty().put(IDnumber, t);
			getMyTurtleModel().selectedTurtlesProperty().put(IDnumber, t);
		}

	}

	@Override
	public void clearSelectedTurtles () {
		getMyTurtleModel().selectedTurtlesProperty().clear();
	}

	@Override
	public Collection<Integer> getSelectedTurtleIDs () {
		ArrayList<Integer> ids = new ArrayList<>();
		for (Integer id: getMyTurtleModel().selectedTurtlesProperty().keySet()) {
			ids.add(id);
		} 
		return ids;
	}

	@Override
	public List<Double> getLineThicknesses () {
		ArrayList<Double> thicknesses = new ArrayList<>();
		for (LineInfo line: myTurtleModel.getReadOnlyLines()) {
			thicknesses.add(line.getThickness());
		}
		return thicknesses;
	}

>>>>>>> plg

	@Override
	public List<Entry<Double, Double>> getLineTypes () {
		ArrayList<Entry<Double, Double>> lineTypes = new ArrayList<>();
		for (LineInfo line: myTurtleModel.getReadOnlyLines()) {
			lineTypes.add(line.getType());
		}
		return lineTypes;
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
	public void setSelectedLineThickness (int i) {
		getMyTurtleModel().setSelectedLineThickness(i);
	}

	@Override
	public void setSelectedLineType (int i) {
		getMyTurtleModel().setSelectedLineType(i);     
	}

	@Override
	public ReadOnlyListProperty<StampInfo> getStamps () {
		return getMyTurtleModel().stampsProperty();
	}

<<<<<<< HEAD
}
=======
	@Override
	public Collection<TurtleInfo> getAllTurtleInfo() {
		return getMyTurtleModel().allTurtlesProperty().values();
	}

	@Override
	public TurtleInfo getTurtle(int id) {
		return getMyTurtleModel().allTurtlesProperty().get(id);
	}


}
>>>>>>> plg
