package controller;

import controller.commands.AbstractExpressionNode;
import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import model.IBasicModel;
import view.UIView;

import java.util.LinkedList;
import java.util.List;
public class ConsoleController {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	public ConsoleController(IBasicModel myModel, UIView myView) {
		myParser = new SLogoParser();
		myInterpreter = new BasicSLogoInterpreter(myModel);
	}

	public void executeCommand(String command, String language) {
		List<AbstractExpressionNode> myNodes= new LinkedList<AbstractExpressionNode>();
		try{
			myNodes= myParser.parse(command, language);
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
