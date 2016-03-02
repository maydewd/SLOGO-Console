package controller;

import java.util.List;
import java.util.LinkedList;

import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import javafx.beans.property.MapProperty;
import model.IBasicModel;
import view.UIView;
import controller.commands.AbstractExpressionNode;
public class ConsoleController {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	private IBasicModel myModel;
	private UIView myView;
	
	public ConsoleController(IBasicModel model, UIView view) {
		myParser = new SLogoParser();
		myModel = model;
		myInterpreter = new BasicSLogoInterpreter(model);
		myView=view;
	}

	public void executeCommand(String command, String language) {
		List<AbstractExpressionNode> myNodes= new LinkedList<AbstractExpressionNode>();
		try{
		        MapProperty<String, List<String>> commandsProperty = myModel.definedCommandsProperty();
		        myModel.commandHistoryProperty().add(command);
			myNodes= myParser.parse(command, language, commandsProperty);
		}
		
		//Show the error
		catch(ParsingException e){
			myView.showError(e.getMessage());
		}
		for(int i=0;i<myNodes.size();i++){
			try{
				myNodes.get(i).execute(myInterpreter);
			}
			catch(ParsingException e){
				myView.showError(e.getMessage());
			}
		}
	}

}
