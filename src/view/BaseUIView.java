package view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import model.IBasicModel;

/**
 * Created by Tim on 29/02/16.
 */
public abstract class BaseUIView {

	public final static int TITLE_SIZE = 14;

	private int width;
	private int height;
	private Node myNode;
	private IBasicModel model;

	public BaseUIView(int width, int height, IBasicModel model){
		this.setWidth(width);
		this.setHeight(height);
		this.model = model;
	}

	protected void setWidth(int width){
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	protected void setHeight(int height){
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	protected void setNode(Node n){
		this.myNode = n;
	}

	public Node getNode() {
		return myNode;
	}

	public void showError(String s){
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Error");
		alert.setContentText(s);
		alert.showAndWait();
	}

	public IBasicModel getModel(){
		return model;
	}

}
