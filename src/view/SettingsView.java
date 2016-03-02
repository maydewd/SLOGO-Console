package view;

import javafx.application.HostServices;
import javafx.scene.Node;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.IBasicModel;


public class SettingsView extends UIView {
	public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 25;
    public static final String HELP_PAGE = "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    
    private Node uiNode;
    private IBasicModel bm;
    private HostServices myHostServices;

	public SettingsView(IBasicModel b, HostServices hostServices) {

	    bm = b;
	    MenuBar settings = new MenuBar();
	    uiNode = settings;
	    myHostServices = hostServices;
	    
	    //Language Selector
	    Menu languageSettings = new Menu("Language");
	    for(int i = 0; i < bm.languageOptionsProperty().getSize(); i++){
	        MenuItem button = new MenuItem(bm.languageOptionsProperty().get(i));
	        int index = i;
	        button.setOnAction(e -> bm.setActiveLanguageIndex(index));
	        languageSettings.getItems().add(button);
	    }
	    
	  //Pen Color Selector
            Menu penColorSettings = new Menu("Pen Color");
            for(int i = 0; i < bm.colorOptionsProperty().getSize(); i++){
                CustomMenuItem button = new CustomMenuItem();
                Circle fill = new Circle();
                fill.setRadius(getWidth()/50);
                fill.setFill(Color.rgb(bm.colorOptionsProperty().get(i).getRed(),
                                       bm.colorOptionsProperty().get(i).getGreen(),
                                       bm.colorOptionsProperty().get(i).getBlue()));
                button.setContent(fill);
                int index = i;
                button.setOnAction(e -> bm.setActivePenColorIndex(index));
                penColorSettings.getItems().add(button);
            }
            
          //Background Color Selector
            Menu backgroundColorSettings = new Menu("Background Color");
            for(int i = 0; i < bm.colorOptionsProperty().getSize(); i++){
                CustomMenuItem button = new CustomMenuItem();
                Circle fill = new Circle();
                fill.setRadius(getWidth()/50);
                fill.setFill(Color.rgb(bm.colorOptionsProperty().get(i).getRed(),
                                       bm.colorOptionsProperty().get(i).getGreen(),
                                       bm.colorOptionsProperty().get(i).getBlue()));
                button.setContent(fill);
                int index = i;
                button.setOnAction(e -> bm.setActiveBackgroundColorIndex(index));
                backgroundColorSettings.getItems().add(button);
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
		help.setOnAction(e -> myHostServices.showDocument(HELP_PAGE));
		
		//Color Selectors
		
		
		helpSettings.getItems().addAll(help);
		settings.getMenus().addAll(languageSettings, penColorSettings, backgroundColorSettings, turtleImageSettings, helpSettings);

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
