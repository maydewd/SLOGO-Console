package controller.parser;

public class ParsingException extends Exception {

    /**
     * Generated serialVersionUID used by the Serializable interface
     */
    private static final long serialVersionUID = 1943409814266335627L;

    public ParsingException () {
        super();
    }

    public ParsingException (String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingException (String message) {
        super(message);
    }

    public ParsingException (Throwable cause) {
        super(cause);
    }

}
