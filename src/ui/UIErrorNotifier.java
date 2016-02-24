package ui;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UIErrorNotifier implements UIView{
	
	public static final int DEFAULT_WIDTH = 200;
	public static final int DEFAULT_HEIGHT = 50;
	
	private int width;
	private int height;
	private Node uiNode;

	public UIErrorNotifier() {
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
	}
	
	/*
	 * Actual Error options
	 */
	
	public void genericError(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error");
		alert.setContentText("I'm sorry, it looks like something went wrong...");
		alert.showAndWait();
	}
	
	public void syntaxError(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error");
		alert.setContentText("Your command is not recognised. Please check that your syntax and language is correct.");
		alert.showAndWait();
	}
	
	public void variableError(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error");
		alert.setContentText("There is an issue with your use of that variable.");
		alert.showAndWait();
	}
	
	public void turtleError(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error");
		alert.setContentText("There is an issue with your use of that turtle.");
		alert.showAndWait();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public Node getNode() {
		return null;
	}

}
