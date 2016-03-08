package view;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import model.IAdvancedModel;
import model.LineInfo;
import model.Point;
import model.RGBColor;
import model.StampInfo;
import model.TurtleInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

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
    private Map<LineInfo, Line> displayedLines = new HashMap<>();
    private Map<StampInfo, ImageView> displayedStamps = new HashMap<>();
    private Map<TurtleInfo, ImageView> displayedTurtles = new HashMap<>();

    private Label turtleCoordinates;

    public TurtleView(IAdvancedModel c){
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
    
    private double scaleTurtleX(double d, ImageView turtle){
        return d - turtle.getFitWidth()/2;
    }

    private double scaleTurtleY(double d, ImageView turtle){
        return d + turtle.getFitHeight()/2;
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
        if(getModel().getLines().isEmpty()){
            clearLines();
        }
        else{
            for (LineInfo l : getModel().getLines()) {
                if (!displayedLines.keySet().contains(l) && l.getVisibility()) {
                   makeLine(l);
                }
            }
        }
        if(getModel().getLines().isEmpty()){
            clearStamps();
        }
        else{
            for(StampInfo s: getModel().getStamps()){
                if (!displayedStamps.keySet().contains(s) && s.getVisibility() ){
                    makeStamp(s);
                }
            }
        }
        for(TurtleInfo turtle: getModel().getAllTurtleInfo()){
            if(displayedTurtles.keySet().contains(turtle)){
                canvas.getChildren().remove(displayedTurtles.get(turtle));
            }
            makeTurtle(turtle);
        }
    }
    
    private void clearStamps () {
        canvas.getChildren().removeAll(displayedStamps.values());
        displayedStamps.clear();
    }

    private void clearLines () {
        canvas.getChildren().removeAll(displayedLines.values());
        displayedLines.clear();
    }

    private void makeStamp (StampInfo s) {
        ImageView stamp = new ImageView();
        stamp.setX(scaleX(getModel().getTurtleCoordinates().getX()));
        stamp.setY(scaleY(getModel().getTurtleCoordinates().getY()));
        displayedStamps.put(s, stamp);
        canvas.getChildren().add(stamp);
    }

    private void makeLine(LineInfo l){
        Line line = new Line();
        line.setStartX(scaleX(l.getStart().getX()));
        line.setStartY(scaleY(l.getStart().getY()));
        line.setEndX(scaleX(l.getEnd().getX()));
        line.setEndY(scaleY(l.getEnd().getY()));

        RGBColor currentColor = getModel().colorOptionsProperty().get(l.getColor());
        line.setStroke(Color.rgb(currentColor.getRed(),
                                 currentColor.getGreen(),
                                 currentColor.getBlue()));

        displayedLines.put(l, line);
        canvas.getChildren().add(line);
    }
    
    private void makeTurtle(TurtleInfo turtle){
        ImageView myTurtle = new ImageView(new Image(getClass().getClassLoader()
                                           .getResourceAsStream(
                                           getModel().turtleImageOptionsProperty()
                                           .get(getModel().getActiveTurtleImageIndex()
                                           .getValue()))));
        myTurtle.setFitHeight(TURTLE_HEIGHT);
        myTurtle.setFitWidth(TURTLE_WIDTH);
        myTurtle.setX(scaleX(scaleTurtleX(getModel().getTurtleCoordinates().getX(), myTurtle)));
        myTurtle.setY(scaleY(scaleTurtleY(getModel().getTurtleCoordinates().getY(), myTurtle)));
        myTurtle.setRotate(- getModel().getTurtleHeading() + HEADING_OFFSET);
        myTurtle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> showInfo(turtle));
        displayedTurtles.put(turtle, myTurtle);
        canvas.getChildren().add(myTurtle);
    }

    private void updateTurtleCoordinates(){
        Point turtlePos = getModel().getTurtleCoordinates();
        String turtlePosString = "(" + turtlePos.getX() + ", " + turtlePos.getY() + ")";
//        System.out.println(turtlePosString);
        this.turtleCoordinates.setText(turtlePosString);

    }
    
    private void showInfo(TurtleInfo turtle){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Turtle Info");
        alert.setHeaderText("Do you want to Select this Turtle?");
        Point turtlePos = getModel().getTurtleCoordinates();
        alert.setContentText("Turtle X: " + turtlePos.getX() + "\n" + 
                             "Turtle Y: " + turtlePos.getY() + "\n" + 
                             "Pen is Down: " + getModel().getPenDown() + "\n" +
                              "Heading: "+ getModel().getTurtleHeading());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            getModel().addSelectedTurtles(turtle.getID());
        }
   
                 
    }
}
