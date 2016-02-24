package ui;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopUp {
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	
	private Stage popUp;
	private Group group;
	private Scene scene;
	

	public PopUp(Node n) {
		 popUp = new Stage();
		 popUp.setWidth(WIDTH);
		 popUp.setHeight(HEIGHT);
		 group = new Group();
	     scene = new Scene(group);
	     popUp.setScene(scene);
	     group.getChildren().add(n);  
	}
	
	public void show(){
		popUp.show();
	}

}
