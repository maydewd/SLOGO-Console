package controller;

import controller.commands.AbstractExpressionNode;
import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import javafx.beans.property.MapProperty;
import model.IBasicModel;
import view.BaseUIView;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton controller class that allows the posting of commands
 */
public class ConsoleController {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	private IBasicModel myModel;
	private BaseUIView myView;

	private static ConsoleController controller = null;
	
	private ConsoleController(IBasicModel model, BaseUIView view) {
		myParser = new SLogoParser();
		myModel = model;
		myInterpreter = new BasicSLogoInterpreter(model);
		myView = view;
	}

	/**
	 * Method to initialize the controller Singleton before getting it with the getController() calls
	 * @param model
	 * @param view
	 */
	public static void initController(IBasicModel model, BaseUIView view){
		if(controller == null){
			controller = new ConsoleController(model, view);
		}
	}

	/**
	 * Returns the ConsoleController if it has been initialized
	 * @return controller may be null if initController has not been called first
	 */
	public static ConsoleController getController(){
		return controller;
	}

	public void executeCommand(String command) {
		List<AbstractExpressionNode> myNodes= new LinkedList<AbstractExpressionNode>();
		try{
			String language = myModel.languageOptionsProperty().get(myModel.getActiveLanguageIndex().get());
	        MapProperty<String, List<String>> commandsProperty = myModel.definedCommandsProperty();
	        myModel.commandHistoryProperty().add(command);
			myNodes= myParser.parse(command, language, commandsProperty);
		}
		
		//Show the error
		catch(ParsingException e){
			myView.showError(e.getMessage());
		}
		for (int i = 0; i < myNodes.size(); i++){
			try{
				myNodes.get(i).execute(myInterpreter);
			}
			catch(ParsingException e){
				myView.showError(e.getMessage());
			}
		}
	}

}
