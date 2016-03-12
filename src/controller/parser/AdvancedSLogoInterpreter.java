package controller.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import model.IAdvancedModel;
import model.RGBColor;

public class AdvancedSLogoInterpreter extends BasicSLogoInterpreter implements IAdvancedSLogoCommands {

	private IAdvancedModel myModelActions;
	
	public AdvancedSLogoInterpreter(IAdvancedModel advancedModel) {
		super(advancedModel);
		setModelActions(advancedModel);
	}

	@Override
	public double getPenColor() {
		return getModelActions().getPenColorIndex().get();
	}

	@Override
	public double getShape() {
		return getModelActions().getTurtleImageIndex().get();
	}

	@Override
	public double stamp() {
		getModelActions().drawStamp();
		return getShape();
	}

	@Override
	public double clearStamps() {
		if (getModelActions().getStamps().size() == 0) {
			return 0;
		}
		else {
			getModelActions().clearStamps();
			return 1;
		}
	}
	
	

	@Override
	public double setPenColor(int index) {
		getModelActions().setPenColorIndex(index);
		return index;
	}

	@Override
	public double setShape(int index) {
		getModelActions().setTurtleImageIndex(index);
		return index;
	}

	@Override
	public double setPalette(int index, int r, int g, int b) {
		getModelActions().colorOptionsProperty().put(index, new RGBColor(r,g,b));
		return index;
	}

	@Override
	public double setBackground(int index) {
		getModelActions().setActiveBackgroundColorIndex(index);
		return index;
	}

	@Override
	public double setPenSize(double pixels) {
		getModelActions().getActiveTurtle().setLineThickness(pixels);
		return pixels;
	}

	@Override
	public double getCurrentActiveID() {
		return getModelActions().getActiveTurtle().getID();
	}

	@Override
	public double getTurtleCount() {
		return getModelActions().getAllTurtleInfo().size();
	}

	@Override
	public double tellAll (List<Integer> ids) {
	        getModelActions().clearSelectedTurtles();
	        ids.forEach(id -> getModelActions().addSelectedTurtle(id));
		return ids.size() != 0 ? ids.get(ids.size()-1) : 0;
	}

    @Override
    public List<Integer> getSelectedTurtles () {
        return getModelActions().getSelectedTurtleIDs();
    }

    @Override
    public List<Integer> getAllTurtles () {
        return getModelActions().getAllTurtleIDs();
    }

    @Override
    public double tell (Integer id) {
        getModelActions().clearSelectedTurtles();
        getModelActions().addSelectedTurtle(id);
        return id;
    }
    
    private IAdvancedModel getModelActions () {
        return myModelActions;
    }
    
    private void setModelActions (IAdvancedModel advancedModel) {
        myModelActions = advancedModel;
    }


}
