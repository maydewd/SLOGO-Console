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
	}

	@Override
	public double getPenColor() {
		return getModelActions().getActivePenColorIndex().get();
	}

	@Override
	public double getShape() {
		return getModelActions().getActiveTurtleImageIndex().get();
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
	
	public IAdvancedModel getModelActions () {
		return myModelActions;
	}

	@Override
	public double setPenColor(int index) {
		getModelActions().setActiveLanguageIndex(index);
		return index;
	}

	@Override
	public double setShape(int index) {
		getModelActions().setActiveTurtleImageIndex(index);
		return index;
	}

	@Override
	public double setPalette(int index, int r, int g, int b) {
		getModelActions().colorOptionsProperty().set(index, new RGBColor(r,g,b));
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
		for (int id: ids) {
			getModelActions().addSelectedTurtles(id);
		}
		return ids.get(ids.size()-1);
	}

    @Override
    public List<Integer> getSelectedTurtles () {
        // TODO Auto-generated method stub
        // new TreeMap().ke
        return new ArrayList<Integer>(getModelActions().getSelectedTurtleIDs());
    }

    @Override
    public List<Integer> getAllTurtles () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double tell (Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }


}
