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
    
    
    private Node uiNode;
    private IBasicModel basicModel;

	public SettingsView(IBasicModel b, HostServices hostServices) {

	    basicModel = b;
	    MenuBar settings = new MenuBar();
	    uiNode = settings;
	    
	    Selector lSelector = new LanguageSelector(basicModel);
	    Selector pColorSelector = new PenColorSelector(basicModel);
	    Selector bColorSelector = new BackgroundColorSelector(basicModel);
	    Selector tSelector = new TurtleSelector(basicModel);
	    Selector hSelector = new HelpSelector(hostServices);
		
	    settings.getMenus().addAll(lSelector.getMenu(), 
		                       pColorSelector.getMenu(), 
		                       bColorSelector.getMenu(), 
		                       tSelector.getMenu(), 
		                       hSelector.getMenu());

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
