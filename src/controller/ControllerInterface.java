package controller;

import model.IBasicModel;
import model.Model;
import view.UIView;

public interface ControllerInterface {
	public void setUp(IBasicModel myModel, UIView myView);
	public void executeCommand (String command, String language);
}
