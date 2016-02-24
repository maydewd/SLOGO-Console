package view;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import controller.FrontEndControllerInterface;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UISettingsView implements UIView{
	public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 25;
    public static final String HELP_PAGE = "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    
    private Node uiNode;
    FrontEndControllerInterface controller;

	public UISettingsView(FrontEndControllerInterface c) {
		MenuBar settings = new MenuBar();
		uiNode = settings;
		controller = c;
		ColorPicker penColorPicker = new ColorPicker();
		penColorPicker.setValue(Color.BLACK);
		
		ColorPicker bColorPicker = new ColorPicker();
		
		//Color Menu
		Menu penColor = new Menu("Pen Color");
		
		CustomMenuItem penColorSelector = new CustomMenuItem(penColorPicker);
		penColorSelector.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent event) {
            	penColorPicker.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						Color c = penColorPicker.getValue();
		        		controller.setPenColor(c);
					}
                });
            }
		});
		
		penColor.getItems().addAll(penColorSelector);
		
		Menu backgroundColor = new Menu("Background Color");
		
		CustomMenuItem backgroundColorSelector = new CustomMenuItem(bColorPicker);
		backgroundColorSelector.setOnAction(new EventHandler<ActionEvent>() {
            @SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent event) {
            	bColorPicker.setOnAction(new EventHandler() {
					@Override
					public void handle(Event event) {
						Color c = bColorPicker.getValue();
		        		controller.setPenColor(c);
					}
                });
            }
		});
		
		backgroundColor.getItems().addAll(backgroundColorSelector);
		
		//Turtle Menu
		Menu turtleSettings = new Menu("Turtle");
		MenuItem turtleImage = new MenuItem("Change Turtle Image");
		turtleImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//ADD ERROR CHECKING
            	FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
                
                File file = fileChooser.showOpenDialog(null);
                if(file != null){
                	 controller.setTurtleImage(file);
                }
               
            }
		});
		turtleSettings.getItems().addAll(turtleImage);

		//Language Menu
		Menu languageSettings = new Menu("Language");

		MenuItem english = new MenuItem("English");
		english.setOnAction(e -> controller.setLanguage("English"));
		MenuItem spanish = new MenuItem("Spanish");
		spanish.setOnAction(e -> controller.setLanguage("Spanish"));
		MenuItem chinese = new MenuItem("Chinese");
		chinese.setOnAction(e -> controller.setLanguage("Chinese"));
		MenuItem french = new MenuItem("French");
		french.setOnAction(e -> controller.setLanguage("French"));
		MenuItem german = new MenuItem("German");
		german.setOnAction(e -> controller.setLanguage("German"));
		MenuItem italian = new MenuItem("Italian");
		italian.setOnAction(e -> controller.setLanguage("Italian"));
		MenuItem portuguese = new MenuItem("Portuguese");
		portuguese.setOnAction(e -> controller.setLanguage("Portuguese"));
		MenuItem russian = new MenuItem("Russian");
		russian.setOnAction(e -> controller.setLanguage("Russian"));

		languageSettings.getItems().addAll(english, spanish, chinese, french, german, italian, portuguese, russian);

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
		settings.getMenus().addAll(penColor, backgroundColor, turtleSettings, languageSettings, helpSettings);

		((MenuBar) uiNode).setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
