package controller;

import controller.commands.AbstractExpressionNode;
import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import javafx.beans.property.MapProperty;
import model.IBasicModel;
import view.UIView;

import java.util.LinkedList;
import java.util.List;
public class ConsoleController {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	private IBasicModel myModel;
	
	public ConsoleController(IBasicModel model, UIView myView) {
		myParser = new SLogoParser();
		myModel = model;
		myInterpreter = new BasicSLogoInterpreter(model);
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
			e.printStackTrace();
		}
		for(int i=0;i<myNodes.size();i++){
			try{
				myNodes.get(i).execute(myInterpreter);
			}
			catch(ParsingException e){
				e.printStackTrace();
			}
		}
	}

}
