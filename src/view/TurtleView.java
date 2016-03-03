package view;


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
import java.util.Set;

/**
 * Created by Tim on 22/02/16.
 */
public class TurtleView extends UIView implements Observer {

    private static final int HEADING_OFFSET = 90;
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 400;
    
    public static final int TURTLE_HEIGHT = 25;
    public static final int TURTLE_WIDTH = 25;
    
            

    private int width;
    private int height;
    private Node uiNode;
    private Pane canvas;
    private IBasicModel bm;
    private Set<LineInfo> displayedLines = new HashSet<>();
    private ImageView myTurtle;

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
    
    private double scaleTurtleX(double d){
        return d - myTurtle.getFitWidth()/2;
    }

    private double scaleTurtleY(double d){
        return d + myTurtle.getFitHeight()/2;
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
        return -y + getHeight() / 2;
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
        canvas.getChildren().remove(myTurtle);
        if (bm.getTurtleVisibility()) {
            myTurtle = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(
                  bm.turtleImageOptionsProperty()
                          .get(bm.getActiveTurtleImageIndex()
                                  .getValue()))));
            myTurtle.setFitHeight(TURTLE_HEIGHT);
            myTurtle.setFitWidth(TURTLE_WIDTH);
            myTurtle.setX(scaleX(scaleTurtleX(bm.getTurtleCoordinates().getX())));
            myTurtle.setY(scaleY(scaleTurtleY(bm.getTurtleCoordinates().getY())));
            myTurtle.setRotate(- bm.getTurtleHeading() + HEADING_OFFSET);
            canvas.getChildren().add(myTurtle);
        }
    }
}
