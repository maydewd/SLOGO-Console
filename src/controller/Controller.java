package controller;

import java.awt.List;
import java.util.ArrayList;

import controller.parser.BasicSLogoInterpreter;
import controller.parser.ParsingException;
import controller.parser.SLogoParser;
import model.BasicModel;
import model.IBasicModel;
import model.Model;
import view.UIView;
import controller.commands.AbstractExpressionNode;
public class Controller implements ControllerInterface {
	private SLogoParser myParser;
	private BasicSLogoInterpreter myInterpreter;
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp(IBasicModel myModel, UIView myView) {
		// TODO Auto-generated method stub
		myParser = new SLogoParser();
		myInterpreter = new BasicSLogoInterpreter((BasicModel)myModel);
		
	}

	@Override
	public void executeCommand(String command, String language) {
		// TODO Auto-generated method stub
		java.util.List<AbstractExpressionNode> myNodes= new ArrayList<AbstractExpressionNode>();
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
