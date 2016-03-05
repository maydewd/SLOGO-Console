package view;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import model.IBasicModel;
import model.LineInfo;
import model.Point;
import model.RGBColor;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 * Created by Tim on 22/02/16.
 */
public class TurtleView extends BaseUIView implements Observer {

    private static final int HEADING_OFFSET = 90;
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 407;
    
    public static final int TURTLE_HEIGHT = 25;
    public static final int TURTLE_WIDTH = 25;
    

    private Pane canvas;
    private Set<LineInfo> displayedLines = new HashSet<>();
    private ImageView myTurtle;

    private Label turtleCoordinates;

    public TurtleView(IBasicModel c){
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, c);

        canvas = new BorderPane();
        initializeCanvas();
        canvas.setPrefSize(getWidth(), getHeight());
        ((BorderPane) canvas).setTop(turtleCoordinates);
        setNode(canvas);
        getModel().addCoreTurtleObserver(this);
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
        getModel().getActiveBackgroundColorIndex().addListener(o -> changeBackgroundColor());
        turtleCoordinates = new Label("Hey");
        turtleCoordinates.setTextAlignment(TextAlignment.CENTER);
    }

    private void changeBackgroundColor () {
        int index = getModel().getActiveBackgroundColorIndex().intValue();
        String hexString = getModel().colorOptionsProperty().get(index).toString();
        canvas.setStyle("-fx-background-color: #" + hexString + ";");
    }

    private double scaleY (double y) {
        return -y + getHeight() / 2;
    }

    @Override
    public void update (Observable o, Object arg) {
        updateView();
    }

    private void updateView () {
        if (getModel().getLines().isEmpty()) {
            canvas.getChildren().clear();
        }
        for (LineInfo l : getModel().getLines()) {
            if (!displayedLines.contains(l) && l.getVisibility()) {
                Line line = new Line();
                line.setStartX(scaleX(l.getStart().getX()));
                line.setStartY(scaleY(l.getStart().getY()));
                line.setEndX(scaleX(l.getEnd().getX()));
                line.setEndY(scaleY(l.getEnd().getY()));

                RGBColor currentColor = getModel().colorOptionsProperty().get(l.getColor());
                line.setStroke(Color.rgb(currentColor.getRed(),
                                         currentColor.getGreen(),
                                         currentColor.getBlue()));

                displayedLines.add(l);
                canvas.getChildren().add(line);
            }
        }
        canvas.getChildren().remove(myTurtle);
        if (getModel().getTurtleVisibility()) {
            myTurtle = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(
                  getModel().turtleImageOptionsProperty()
                          .get(getModel().getActiveTurtleImageIndex()
                                  .getValue()))));

            myTurtle.setFitHeight(TURTLE_HEIGHT);
            myTurtle.setFitWidth(TURTLE_WIDTH);
            myTurtle.setX(scaleX(scaleTurtleX(getModel().getTurtleCoordinates().getX())));
            myTurtle.setY(scaleY(scaleTurtleY(getModel().getTurtleCoordinates().getY())));
            myTurtle.setRotate(- getModel().getTurtleHeading() + HEADING_OFFSET);
            canvas.getChildren().add(myTurtle);
        }

        updateTurtleCoordinates();
    }

    private void updateTurtleCoordinates(){
        Point turtlePos = getModel().getTurtleCoordinates();
        String turtlePosString = "(" + turtlePos.getX() + ", " + turtlePos.getY() + ")";
        System.out.println(turtlePosString);
        this.turtleCoordinates.setText(turtlePosString);

    }
}
