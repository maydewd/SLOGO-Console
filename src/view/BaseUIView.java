package view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import model.IAdvancedModel;


/**
 * Created by Tim on 29/02/16.
 */
public abstract class BaseUIView {

    public final static int TITLE_SIZE = 14;

    private int myWidth;
    private int myHeight;
    private Node myNode;
    private IAdvancedModel myModel;

    public BaseUIView (int width, int height, IAdvancedModel model) {
        setWidth(width);
        setHeight(height);
        myModel = model;
    }

    protected void setWidth (int width) {
        myWidth = width;
    }

    public int getWidth () {
        return myWidth;
    }

    protected void setHeight (int height) {
        myHeight = height;
    }

    public int getHeight () {
        return myHeight;
    }

    protected void setNode (Node n) {
        myNode = n;
    }

    public Node getNode () {
        return myNode;
    }

    public void showError (String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert");
        alert.setHeaderText("Error");
        alert.setContentText(s);
        alert.showAndWait();
    }

    public IAdvancedModel getModel () {
        return myModel;
    }

}
