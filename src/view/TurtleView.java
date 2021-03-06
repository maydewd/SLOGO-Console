package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.IAdvancedModel;
import model.LineInfo;
import model.Point;
import model.RGBColor;
import model.StampInfo;
import model.TurtleInfo;


/**
 * Created by Tim on 22/02/16.
 */
public class TurtleView extends BaseUIView implements Observer {

    private static final int HEADING_OFFSET = 90;
    public static final int DEFAULT_WIDTH = 550;
    public static final int DEFAULT_HEIGHT = 407;

    public static final int TURTLE_HEIGHT = 25;
    public static final int TURTLE_WIDTH = 25;

    private Pane myCanvas;
    private Map<LineInfo, Line> myDisplayedLines = new HashMap<>();
    private Map<StampInfo, ImageView> myDisplayedStamps = new HashMap<>();
    private Map<TurtleInfo, ImageView> myDisplayedTurtles = new HashMap<>();

    // private Label myTurtleCoordinates;

    public TurtleView (IAdvancedModel c) {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, c);

        myCanvas = new BorderPane();
        initializeCanvas();
        myCanvas.setPrefSize(getWidth(), getHeight());
        // ((BorderPane) myCanvas).setTop(myTurtleCoordinates);
        setNode(myCanvas);
        getModel().addCoreTurtleObserver(this);
        updateView();
    }

    /*
     * Scales values to the turtleView Scale
     */
    private double scaleX (double d) {
        return d + getWidth() / 2;
    }

    private double scaleY (double y) {
        return -y + getHeight() / 2;
    }

    private double scaleTurtleX (double d, ImageView turtle) {
        return d - turtle.getFitWidth() / 2;
    }

    private double scaleTurtleY (double d, ImageView turtle) {
        return d + turtle.getFitHeight() / 2;
    }

    private void initializeCanvas () {
        getModel().getActiveBackgroundColorIndex().addListener(o -> changeBackgroundColor());
    }

    private void changeBackgroundColor () {
        int index = getModel().getActiveBackgroundColorIndex().intValue();
        String hexString = getModel().colorOptionsProperty().get(index).toString();
        myCanvas.setStyle("-fx-background-color: #" + hexString + ";");
    }

    @Override
    public void update (Observable o, Object arg) {
        updateView();
    }

    private void updateView () {
        if (getModel().getLines().isEmpty()) {
            clearLines();
        }
        else {
            for (LineInfo l : getModel().getLines()) {
                if (!myDisplayedLines.keySet().contains(l) && l.getVisibility()) {
                    makeLine(l);
                }
            }
        }
        if (getModel().getStamps().isEmpty()) {
            clearStamps();
        }
        else {
            for (StampInfo s : getModel().getStamps()) {
                if (!myDisplayedStamps.keySet().contains(s)) { // && s.getVisibility() ){
                    makeStamp(s);
                }
            }
        }
        for (TurtleInfo turtle : getModel().getAllTurtleInfo()) {
            if (myDisplayedTurtles.keySet().contains(turtle)) {
                myCanvas.getChildren().remove(myDisplayedTurtles.get(turtle));
            }
            makeTurtle(turtle);
        }
    }

    private void clearStamps () {
        myCanvas.getChildren().removeAll(myDisplayedStamps.values());
        myDisplayedStamps.clear();
    }

    private void clearLines () {
        myCanvas.getChildren().removeAll(myDisplayedLines.values());
        myDisplayedLines.clear();
    }

    private void makeStamp (StampInfo s) {
        ImageView stamp = new ImageView(new Image(getClass().getClassLoader()
                .getResourceAsStream(
                                     getModel().turtleImageOptionsProperty()
                                             .get(s.getImageIndex()))));
        stamp.setFitHeight(TURTLE_HEIGHT);
        stamp.setFitWidth(TURTLE_WIDTH);
        stamp.setX(scaleX(scaleTurtleX(s.getLocation().getX(), stamp)));
        stamp.setY(scaleY(scaleTurtleY(s.getLocation().getY(), stamp)));
        stamp.setRotate(-s.getRotation() + HEADING_OFFSET);
        myDisplayedStamps.put(s, stamp);
        myCanvas.getChildren().add(stamp);
    }

    private void makeLine (LineInfo l) {
        Line line = new Line();
        line.setStartX(scaleX(l.getStart().getX()));
        line.setStartY(scaleY(l.getStart().getY()));
        line.setEndX(scaleX(l.getEnd().getX()));
        line.setEndY(scaleY(l.getEnd().getY()));

        RGBColor currentColor = getModel().colorOptionsProperty().get(l.getColor());
        line.setStroke(Color.rgb(currentColor.getRed(),
                                 currentColor.getGreen(),
                                 currentColor.getBlue()));
        line.setStrokeWidth(l.getThickness());
        line.getStrokeDashArray().addAll(l.getTypeIndex().getPixelsOn(),
                                         l.getTypeIndex().getPixelsOff());

        myDisplayedLines.put(l, line);
        myCanvas.getChildren().add(line);
    }

    private void makeTurtle (TurtleInfo turtle) {
        ImageView myTurtle = new ImageView(new Image(getClass().getClassLoader()
                .getResourceAsStream(
                                     getModel().turtleImageOptionsProperty()
                                             .get(turtle.getImageIndex()))));
        myTurtle.setFitHeight(TURTLE_HEIGHT);
        myTurtle.setFitWidth(TURTLE_WIDTH);
        myTurtle.setX(scaleX(scaleTurtleX(turtle.getLocation().getX(), myTurtle)));
        myTurtle.setY(scaleY(scaleTurtleY(turtle.getLocation().getY(), myTurtle)));
        myTurtle.setRotate(-turtle.getHeading() + HEADING_OFFSET);
        myTurtle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> showInfo(turtle));
        myDisplayedTurtles.put(turtle, myTurtle);
        myCanvas.getChildren().add(myTurtle);
    }

    private void showInfo (TurtleInfo turtle) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Turtle Info");
        alert.setHeaderText("Do you want to Select this Turtle?");
        Point turtlePos = turtle.getLocation();
        alert.setContentText("ID: " + turtle.getID() + "\n" +
                             "Turtle X: " + turtlePos.getX() + "\n" +
                             "Turtle Y: " + turtlePos.getY() + "\n" +
                             "Pen is Down: " + getModel().getPenDown() + "\n" +
                             "Heading: " + turtle.getHeading() + "\n" +
                             "Selected: " +
                             getModel().getSelectedTurtleIDs().contains(turtle.getID()));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            getModel().addSelectedTurtle(turtle.getID());
        }
    }
}
