package view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by Tim on 22/02/16.
 */
public abstract class UIView {

	abstract int getWidth();

	abstract int getHeight();

	/**
	 * This method returns the Node that contains all of UI for this View
	 *
	 * @return view Node
	 */
	abstract Node getNode();
	
	public void Error(String s){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText("Error");
            alert.setContentText(s);
            alert.showAndWait();
    }
}
