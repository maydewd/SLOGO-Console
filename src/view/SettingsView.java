package view;

import javafx.application.HostServices;
import javafx.scene.control.MenuBar;
import model.IAdvancedModel;


public class SettingsView extends BaseUIView{
    public static final int DEFAULT_WIDTH = 550;
    public static final int DEFAULT_HEIGHT = 25;
	
    private HostServices myHostServices;

	public SettingsView(IAdvancedModel b, HostServices hostServices) {
	    super(DEFAULT_WIDTH, DEFAULT_HEIGHT, b);
	    myHostServices = hostServices;

	    MenuBar settings = new MenuBar();
	    setNode(settings);
	    
	    Selector lSelector = new LanguageSelector(getModel());
	    Selector pSelector = new PenSettings(getModel());
	    Selector bColorSelector = new BackgroundColorSelector(getModel());
	    Selector tSelector = new TurtleSelector(getModel());
	    Selector hSelector = new HelpSelector(myHostServices); 
	    Selector fSelector = new FileSelector(myHostServices, getModel(), this);;
		
	    settings.getMenus().addAll(fSelector.getMenu(),
	                               lSelector.getMenu(), 
		                       pSelector.getMenu(), 
		                       bColorSelector.getMenu(), 
		                       tSelector.getMenu(), 
		                       hSelector.getMenu());

	    settings.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
