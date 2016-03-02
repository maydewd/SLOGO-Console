package view;

import javafx.collections.ObservableList;
import model.IBasicModel;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryView extends UIListView {

	public CommandHistoryView(IBasicModel model, String title, ObservableList listToWatch) {
		super(model, title, listToWatch);
	}
}
