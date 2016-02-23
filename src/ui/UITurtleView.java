package ui;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * Created by Tim on 22/02/16.
 */
public class UITurtleView implements UIView{

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    private int width;
    private int height;
    private Node uiNode;

    public UITurtleView(){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        Canvas c = new Canvas();
        uiNode = new Canvas();
        uiNode.setStyle("-fx-background: #FFFFFF;");
        uiNode.autosize();
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
