package controller.configurations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import controller.ConsoleController;
import controller.commands.AbstractExpressionNode;
import controller.parser.ParsingException;
import javafx.beans.property.MapProperty;
import model.IAdvancedModel;


public class FileManager {
    private Map<String, AbstractExpressionNode> myCommandBodies;
    private MapProperty<String, List<String>> myCommandDefinitions;
    private MapProperty<String, Double> myVariables;
    private ConsoleController controller;

    public FileManager (IAdvancedModel myModel) {
        myCommandBodies = myModel.userCommandsBodies();
        myCommandDefinitions = myModel.definedCommandsProperty();
        myVariables = myModel.variableMapProperty();
        controller = ConsoleController.getController();

    }

    public void save (File myFile) throws FileNotFoundException, ParsingException {
        PrintWriter myPrint = new PrintWriter(myFile);
        saveVariables(myPrint);
        saveCommands(myPrint);
    }

    public void saveVariables (PrintWriter myPrint) {
        for (String s : myVariables.keySet()) {
            StringBuilder newString = new StringBuilder();
            newString.append("set ");
            newString.append(s);
            newString.append(" ");
            newString.append(myVariables.get(s));
            myPrint.write(newString.toString());
            myPrint.println();
            myPrint.flush();
        }
    }

    public void saveCommands (PrintWriter myPrint) {
        for (String s : myCommandBodies.keySet()) {
            StringBuilder newString = new StringBuilder();
            newString.append("to ");
            newString.append(s);
            newString.append(" ");
            newString.append("[");
            newString.append(" ");
            List<String> myStrings = new ArrayList<String>();
            myStrings = myCommandDefinitions.get(s);
            for (int j = 0; j < myStrings.size(); j++) {
                newString.append(myStrings.get(j));
                newString.append(" ");
            }
            newString.append("] ");
            newString.append(myCommandBodies.get(s).toString());
            myPrint.write(newString.toString());
            myPrint.println();
            myPrint.flush();
        }
        myPrint.close();
    }

    public void load (File f) throws FileNotFoundException {
        Scanner myScanner = new Scanner(f);
        while (myScanner.hasNextLine()) {
            String command = myScanner.nextLine();
            controller.executeCommand(command);
        }
        myScanner.close();

    }

}
