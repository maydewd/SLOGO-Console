package controller.configurations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import controller.ConsoleController;
import controller.commands.AbstractExpressionNode;
import controller.parser.ParsingException;
import javafx.beans.property.MapProperty;
import model.BasicOptionsModel;
import model.IAdvancedModel;

public class FileManager {
        private Map<String, AbstractExpressionNode> myCommands;
        private MapProperty<String, List<String>> myVariables;
        private BasicOptionsModel myOptionsModel;
        private ConsoleController controller;
        public FileManager(IAdvancedModel myModel) {
                myOptionsModel=myModel.getMyOptionsModel();
                myCommands=myOptionsModel.userCommandsBodies();
                myVariables=myOptionsModel.definedCommandsProperty();
                controller=ConsoleController.getController();
                
        }
        public File save(File myFile) throws FileNotFoundException, ParsingException{
                PrintWriter myPrint=new PrintWriter(myFile);
                StringBuilder newString=new StringBuilder();
                for(String s:myCommands.keySet()){
                        newString.append("to ");
                        newString.append(s);
                        newString.append(" ");
                        newString.append("[");
                        newString.append(" ");
                        List<String> myStrings=new ArrayList<String>();
                        myStrings=myVariables.get(s);
                        for(int j=0;j<myStrings.size();j++){
                            newString.append(myStrings.get(j));
                            newString.append(" ");
                    }
                    newString.append("]");
                    newString.append(myCommands.get(s).toString());
                    myPrint.write(newString.toString());
                    myPrint.println();
            }
            return myFile;
    }
    public void load(File f) throws FileNotFoundException{
            Scanner myScanner=new Scanner(f);
            while(myScanner.nextLine()!=null){
                    String command=myScanner.nextLine();
                    controller.executeCommand(command);
            }
            
    }

}