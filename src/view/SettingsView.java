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


public class SettingsView extends BaseUIView{
	public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 25;
	
    private HostServices myHostServices;

	public SettingsView(IBasicModel b, HostServices hostServices) {
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT, b);
		this.myHostServices = hostServices;

	    MenuBar settings = new MenuBar();
	    setNode(settings);
	    
	    Selector lSelector = new LanguageSelector(getModel());
	    Selector pSelector = new PenSelector(getModel());
	    Selector bColorSelector = new BackgroundColorSelector(getModel());
	    Selector tSelector = new TurtleSelector(getModel());
	    Selector hSelector = new HelpSelector(myHostServices);
		
	    settings.getMenus().addAll(lSelector.getMenu(), 
		                       pSelector.getMenu(), 
		                       bColorSelector.getMenu(), 
		                       tSelector.getMenu(), 
		                       hSelector.getMenu());

	    settings.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
