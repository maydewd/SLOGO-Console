package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class SetPaletteNode extends SimpleProcedureNode {
    
    private static final int SETP_NUM_PARAMS = 4;

    public SetPaletteNode (String text) {
        super(text, SETP_NUM_PARAMS);
    }


    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        int index = (int) getChildren().get(0).execute(commands);
        int r = (int) getChildren().get(1).execute(commands);
        int g = (int) getChildren().get(2).execute(commands);
        int b = (int) getChildren().get(3).execute(commands);
        return commands.setPalette(index, r, g, b);
    }

}
