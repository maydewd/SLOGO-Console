package controller.configurations;

public class ConfigurationException extends Exception {

    /**
     * Generated serialVersionUID used by the Serializable interface
     */
    private static final long serialVersionUID = 1079849942556252572L;

    public ConfigurationException () {
    }

    public ConfigurationException (String message) {
        super(message);
    }

    public ConfigurationException (Throwable cause) {
        super(cause);
    }

    public ConfigurationException (String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException (String message,
                                   Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
