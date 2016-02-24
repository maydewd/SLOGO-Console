package ui;



import app.FrontEndControllerInterface;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Tim on 22/02/16.
 */
public class UITurtleView implements UIView{

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    private int width;
    private int height;
    private Node uiNode;
    private GraphicsContext graphicsContext;
    private Canvas canvas;
    private FrontEndControllerInterface controller;

    public UITurtleView(FrontEndControllerInterface c){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        controller = c;
        
        canvas = new Canvas(width, height);
        uiNode = canvas;
        graphicsContext = canvas.getGraphicsContext2D();
        ((Canvas) uiNode).setHeight(height);
        ((Canvas) uiNode).setWidth(width);

    }
    
    public void updateTurtleView(Delta d){
    	graphicsContext.setStroke(controller.getPenColor());
    	graphicsContext.setFill(controller.getBackgroundColor());
    	if(d.line){
    		graphicsContext.strokeLine(scaleX(d.oldX), scaleY(d.oldY), scaleX(d.newX), scaleY(d.newY));
    	}	
    }
   
    /*
     * Scales values to the turtleView Scale
     */
    private int scaleX(int x){
    	return x;
    }
    
    private int scaleY(int y){
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
}
