package ui;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Created by Tim on 22/02/16.
 */
public class UITurtleView implements UIView {

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    private int width;
    private int height;
    private Node uiNode;
    private UIManager uiManager;

    public UITurtleView(UIManager manager){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        this.uiManager = manager;


        uiNode = new Pane();
        uiNode.setStyle("-fx-background-color: black;");
        ((Pane) uiNode).setPrefSize(width, height);

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
        return uiNode;
    }
}
