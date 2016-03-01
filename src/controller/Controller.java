package controller;

import java.util.List;
import java.util.LinkedList;

import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import model.IBasicModel;
import view.UIView;
import controller.commands.AbstractExpressionNode;
public class Controller {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public void setUp(IBasicModel myModel, UIView myView) {
		// TODO Auto-generated method stub
		myParser = new SLogoParser();
		myInterpreter = new BasicSLogoInterpreter(myModel);
		
	}

	public void executeCommand(String command, String language) {
		// TODO Auto-generated method stub
		List<AbstractExpressionNode> myNodes= new LinkedList<AbstractExpressionNode>();
		try{
			myNodes= myParser.parse(command, language);
		}
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
