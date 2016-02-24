package ui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Created by Tim on 22/02/16.
 */
public class UIConsoleView implements UIView {


    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 100;

    private int width;
    private int height;
    private Node uiNode;
    private TextArea commandField;
    private UIManager uiManager;

    public UIConsoleView(UIManager manager){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        uiNode = new Pane();
        commandField = new TextArea();
        uiManager = manager;

        uiNode.setStyle("-fx-background-color: red;");
        ((Pane) uiNode).setPrefSize(width, height);
        ((Pane) uiNode).getChildren().add(commandField);
        commandField.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                uiManager.debugPostNewCommand(commandField.getText());
                commandField.clear();
            }
        });

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
