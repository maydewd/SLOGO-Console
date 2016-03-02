package view;


import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.IBasicModel;
import model.LineInfo;
import model.RGBColor;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Tim on 22/02/16.
 */
public class TurtleView extends UIView implements Observer {

    private static final int HEADING_OFFSET = 90;
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 400;

    private int width;
    private int height;
    private Node uiNode;
    private Pane canvas;
    private IBasicModel bm;
    private HashSet<LineInfo> displayedLines;

    public TurtleView(IBasicModel c){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        bm = c;
        canvas = new Pane();
        initializeCanvas();
        canvas.setPrefSize(width, height);
        uiNode = canvas;
        bm.addCoreTurtleObserver(this);
        updateView();
    }

    /*
     * Scales values to the turtleView Scale
     */
    private double scaleX (double d) {
        return d + getWidth() / 2;
    }

    private void initializeCanvas () {
        bm.getActiveBackgroundColorIndex().addListener(o -> changeBackgroundColor());
    }

    private void changeBackgroundColor () {
        int index = bm.getActiveBackgroundColorIndex().intValue();
        String hexString = bm.colorOptionsProperty().get(index).toString();
        canvas.setStyle("-fx-background-color: #" + hexString + ";");
    }

    private double scaleY (double y) {
        return y + getHeight() / 2;
    }

    @Override
    public int getWidth () {
        return width;
    }

    @Override
    public int getHeight () {
        return height;
    }

    @Override
    public Node getNode () {
        return uiNode;
    }

    @Override
    public void update (Observable o, Object arg) {
        updateView();
    }

    private void updateView () {
        if (bm.getLines().isEmpty()) {
            canvas.getChildren().clear();
        }
        for (LineInfo l : bm.getLines()) {
            if (!displayedLines.contains(l) && l.getVisibility()) {
                Line line = new Line();
                line.setStartX(scaleX(l.getStart().getX()));
                line.setStartY(scaleY(l.getStart().getY()));
                line.setEndX(scaleX(l.getEnd().getX()));
                line.setEndY(scaleY(l.getEnd().getY()));

                RGBColor currentColor = bm.colorOptionsProperty().get(l.getColor());
                line.setStroke(Color.rgb(currentColor.getRed(),
                                         currentColor.getGreen(),
                                         currentColor.getBlue()));

                displayedLines.add(l);
                canvas.getChildren().add(line);
            }
        }
        for (Node i : canvas.getChildren()) {
            if (i instanceof ImageView) {
                canvas.getChildren().remove(i);
            }
        }
        if (bm.getTurtleVisibility()) {
            ImageView t = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(
                                                                                                  bm.turtleImageOptionsProperty()
                                                                                                          .get(bm.getActiveTurtleImageIndex()
                                                                                                                  .getValue()))));
            t.setX(scaleX(bm.getTurtleCoordinates().getX()));
            t.setY(scaleY(bm.getTurtleCoordinates().getY()));
            t.setRotate(bm.getTurtleHeading() + HEADING_OFFSET);
            canvas.getChildren().add(t);
        }
    }
}
