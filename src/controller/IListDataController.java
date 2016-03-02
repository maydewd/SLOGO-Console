package controller;

import javafx.collections.ObservableList;

/**
 * Created by Tim on 01/03/16.
 */
public interface IListDataController {

	void initDataIntoOL();

	ObservableList getDataOL();

	void updateOLData();
}
