package view;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import model.IBasicModel;
import model.RGBColor;

public class UISettingsView implements UIView{
	public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 25;
    public static final String HELP_PAGE = "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    
    private Node uiNode;
    private IBasicModel bm;

	public UISettingsView(IBasicModel b) {
	    bm = b;
	    MenuBar settings = new MenuBar();
	    uiNode = settings;
	    
	    //Language Selector
	    Menu languageSettings = new Menu("Language");
	    for(int i = 0; i < bm.languageOptionsProperty().getSize(); i++){
	        MenuItem button = new MenuItem(bm.languageOptionsProperty().get(i));
	        int index = i;
	        button.setOnAction(e -> bm.setActiveLanguageIndex(index));
	        languageSettings.getItems().add(button);
	    }
	    
	    
		
		
		//Turtle Menu
		Menu turtleImageSettings = new Menu("Turtle Images");
		for(int i = 0; i < bm.turtleImageOptionsProperty().getSize(); i++){
	                MenuItem button = new MenuItem("");
	                button.setGraphic(new ImageView(bm.turtleImageOptionsProperty().get(i)));
	                int index = i;
	                button.setOnAction(e -> bm.setActiveTurtleImageIndex(index));
	                turtleImageSettings.getItems().add(button);
	        }
		

		//Help Button
		Menu helpSettings = new Menu("Help");

		MenuItem help = new MenuItem("Get Help");
		help.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try{java.awt.Desktop.getDesktop().browse(new URI(HELP_PAGE));}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
			});
		
		
		helpSettings.getItems().addAll(help);
		settings.getMenus().addAll(languageSettings, turtleImageSettings, helpSettings);
		settings.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	public int getWidth() {
		return DEFAULT_WIDTH;
	}

	@Override
	public int getHeight() {
		return DEFAULT_HEIGHT;
	}

	@Override
	public Node getNode() {
		return uiNode;
	}

}
