package view;



import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import model.IBasicModel;
import model.LineInfo;

/**
 * Created by Tim on 22/02/16.
 */
public class UITurtleView implements UIView, Observer{

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    private int width;
    private int height;
    private Node uiNode;
    private Pane canvas;
    private IBasicModel bm;
    private HashSet<LineInfo> displayedLines; 

    public UITurtleView(IBasicModel c){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        bm = c;
        canvas = new Pane();
        canvas.setPrefSize(width, height);
        uiNode = canvas;

    }
   
    /*
     * Scales values to the turtleView Scale
     */
    private double scaleX(double d){
    	return d;
    }
    
    private double scaleY(double y){
    	return y;
    }
    
    @Override
    public int getWidth(){
        return width;
    }

    @Override
    public int getHeight(){
        return height;
    }

    @Override
    public Node getNode(){
        return uiNode;
    }

    @Override
    public void update (Observable o, Object arg) {
        if(bm.getLines().isEmpty()){
            canvas.getChildren().clear();
        }
        for(LineInfo l: bm.getLines()){
            if(!displayedLines.contains(l) && l.getVisibility()){
                Line line = new Line();
                line.setStartX(scaleX(l.getStart().getX()));
                line.setStartY(scaleY(l.getStart().getY()));
                line.setEndX(scaleX(l.getEnd().getX()));
                line.setEndY(scaleY(l.getEnd().getY()));
                
                line.setStroke(Color.rgb(l.getColor().getRed(), l.getColor().getGreen(), l.getColor().getBlue()));
                displayedLines.add(l);
            }
        }
        for(Node i: canvas.getChildren()){
            if(i instanceof ImageView){
                canvas.getChildren().remove(i);
            }
        }
        if(bm.getTurtleVisibility()){
            ImageView t = new ImageView(bm.turtleImageOptionsProperty().get(bm.getActiveTurtleImageIndex().getValue()));
            t.setX(scaleX(bm.getTurtleCoordinates().getX()));
            t.setY(scaleY(bm.getTurtleCoordinates().getY()));
            t.setRotate(bm.getTurtleHeading());
            canvas.getChildren().add(t);
        }
    }
}
