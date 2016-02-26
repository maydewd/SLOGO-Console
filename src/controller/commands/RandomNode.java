package controller.commands;

import java.util.Random;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class RandomNode extends SimpleProcedureNode {

    private static final int RAND_NUM_PARAMS = 1;

    public RandomNode (String text) {
        super(text, RAND_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return new Random().nextDouble() * getChildren().get(0).execute(commands);
    }

}
