package view;

import model.IBasicModel;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryView extends UIListView {

	public CommandHistoryView(IBasicModel model) {
		super(model, model.commandHistoryProperty());
	}
}
