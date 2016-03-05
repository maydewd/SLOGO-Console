package view;

import model.IBasicModel;

/**
 * Created by Tim on 02/03/16.
 */
public abstract class BaseListView extends BaseUIView implements IListDataView{

	public BaseListView(int width, int height, IBasicModel model) {
		super(width, height, model);
	}

}
