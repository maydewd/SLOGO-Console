package ui;

import app.FrontEndControllerInterface;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class UISettingsView implements UIView{
	public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 25;
    
    private Node uiNode;
    ColorPicker colorPicker;
    FrontEndControllerInterface controller;

	public UISettingsView(FrontEndControllerInterface c) {
		MenuBar settings = new MenuBar();
		uiNode = settings;
		controller = c;
		
		
		//Color Menu
		Menu colorSettings = new Menu("Color Settings");
		
		MenuItem penColor = new MenuItem("Pen Color");
		penColor.setOnAction(e -> selectPenColor());
		MenuItem backgroundColor = new MenuItem("Background Color");
		penColor.setOnAction(e -> selectBackgroundColor());
		
		colorSettings.getItems().addAll(penColor, backgroundColor);
		
		//Turtle Menu
		Menu turtleSettings = new Menu("Turtle");
		MenuItem turtleImage = new MenuItem("Change Turtle Image");
		turtleImage.setOnAction(e -> controller.setPenColor(Color.BLACK));
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
		help.setOnAction(e -> controller.setPenColor(Color.BLACK));
		
		helpSettings.getItems().addAll(help);
		
		
		settings.getMenus().addAll(colorSettings, turtleSettings, languageSettings, helpSettings);
		
		((MenuBar) uiNode).setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	public int getWidth() {
		return DEFAULT_WIDTH;
	}
	
	private void selectPenColor(){
		colorPicker = new ColorPicker();
		colorPicker.setOnAction(e -> controller.setPenColor(colorPicker.getValue()));
	}
	private void selectBackgroundColor(){
		 colorPicker = new ColorPicker();
		 colorPicker.setOnAction(e -> controller.setBackgroundColor(colorPicker.getValue()));
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
