package controller.commands;

import java.util.ArrayList;
import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class AskWithNode extends AbsQueryNode {

    private static final int ASKW_NUM_PARAMS = 2;

    public AskWithNode (String text) {
        super(text, ASKW_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        List<Integer> oldSelected = new ArrayList<>(commands.getSelectedTurtles());
        List<Integer> matchingTurtleIDs = getMatchingTurtleIDs(commands);
        commands.tellAll(matchingTurtleIDs);
        double retValue = getChildren().get(1).execute(commands);
        commands.tellAll(oldSelected);
        return retValue;
    }

    private List<Integer> getMatchingTurtleIDs (IAdvancedSLogoCommands commands) throws ParsingException {
        List<Integer> allTurtles = commands.getAllTurtles();
        List<Integer> matchingTurtleIDs = new ArrayList<>();
        for (Integer turtleIndex : allTurtles) {
            commands.tell(turtleIndex);
            if (getChildren().get(0).execute(commands) != 0) {
                matchingTurtleIDs.add(turtleIndex);
            }
        }
        return matchingTurtleIDs;
    }

}
