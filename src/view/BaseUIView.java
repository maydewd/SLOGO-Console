package view;

import javafx.scene.Node;

/**
 * Created by Tim on 29/02/16.
 */
public abstract class BaseUIView extends UIView {

	public final static int TITLE_SIZE = 14;

	private int width;
	private int height;
	private Node myNode;

	public BaseUIView(int width, int height){
		this.setWidth(width);
		this.setHeight(height);
	}

	protected void setWidth(int width){
		this.width = width;
	}

	@Override
	public int getWidth() {
		return width;
	}

	protected void setHeight(int height){
		this.height = height;
	}

	@Override
	public int getHeight() {
		return height;
	}

	protected void setNode(Node n){
		this.myNode = n;
	}

	@Override
	public Node getNode() {
		return myNode;
	}

}
