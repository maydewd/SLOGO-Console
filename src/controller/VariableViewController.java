package controller;

import model.IBasicModel;
import view.BaseListView;

/**
 * Created by Tim on 01/03/16.
 */
public class VariableViewController implements IListDataController{

	private IBasicModel myModel;
	private BaseListView variableView;

	public VariableViewController(BaseListView varView, IBasicModel model) {
		this.variableView = varView;
		this.myModel = model;
		//initDataIntoOL();
	}

    @Override
    public void initDataIntoOL () {
        // TODO should be removed later by timothy
        
    }

    @Override
    public void updateOLData () {
        // TODO should be removed later by timothy
        
    }


}
