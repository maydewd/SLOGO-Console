package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Tim on 02/03/16.
 */
public abstract class BaseListView extends BaseUIView implements IListDataView{

	private ObservableList olDataList = FXCollections.emptyObservableList();

	public BaseListView(int width, int height) {
		super(width, height);
	}

}
