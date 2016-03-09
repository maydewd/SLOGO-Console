package view;

import model.IAdvancedModel;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryView extends UIListView {

	public CommandHistoryView(IAdvancedModel model) {
		super(model, model.commandHistoryProperty());
	}
}
