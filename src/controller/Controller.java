package controller;

import java.util.List;
import java.util.LinkedList;

import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import model.BasicModelActions;
import view.UIView;
import controller.commands.AbstractExpressionNode;
public class Controller implements ControllerInterface {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp(BasicModelActions myModel, UIView myView) {
		// TODO Auto-generated method stub
		myParser = new SLogoParser();
		myInterpreter = new BasicSLogoInterpreter(myModel);
		
	}

	@Override
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
