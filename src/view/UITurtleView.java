package view;


import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.BasicModelSettings;
import model.Delta;

/**
 * Created by Tim on 22/02/16.
 */
public class UITurtleView implements UIView {

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;

	private int width;
	private int height;
	private Node uiNode;
	private GraphicsContext graphicsContext;
	private Canvas canvas;
	private BasicModelSettings bms;

	public UITurtleView(BasicModelSettings b) {
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		bms = b;

		canvas = new Canvas();
		uiNode = canvas;
		graphicsContext = canvas.getGraphicsContext2D();
		((Canvas) uiNode).setHeight(height);
		((Canvas) uiNode).setWidth(width);

	}

	public void updateTurtleView(Delta d) {
		graphicsContext.setStroke(Color.rgb((int) bms.getPenColor().getRed(), (int) bms.getPenColor().getBlue(), (int) bms.getPenColor().getGreen()));
		graphicsContext.setFill(Color.rgb((int) bms.getBackgroundColor().getRed(), (int) bms.getBackgroundColor().getBlue(), (int) bms.getBackgroundColor().getGreen()));
		if (d.getPenDown()) {
			graphicsContext.strokeLine(scaleX(d.getOldX()), scaleY(d.getOldY()), scaleX(d.getNewX()), scaleY(d.getNewY()));
		}
	}


	/*
	 * Scales values to the turtleView Scale
	 */
	private int scaleX(int x) {
		return x;
	}

	private int scaleY(int y) {
		return y;
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
