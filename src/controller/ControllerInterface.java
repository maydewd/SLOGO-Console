package controller;

import model.BasicModelActions;
import view.UIView;

public interface ControllerInterface {
	public void setUp(BasicModelActions myModel, UIView myView);
	public void executeCommand (String command, String language);
}
