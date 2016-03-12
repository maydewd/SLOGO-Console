package model;

import java.io.File;
import controller.configurations.ConfigurationException;


/**
 * Multiple model manager for supporting multiple workspaces
 *
 * @author David Maydew
 *
 */
public interface IAdvancedModelManager extends IAdvancedModel {

    /**
     * creates a new model at the next index, from the default configuration file
     */
    void createNewWorkspace ();

    /**
     * creates a new model at the next index, from the specified configuration file
     */
    void loadNewWorkspace (File xmlConfigFile) throws ConfigurationException;

    /**
     * switches to an already created workspace
     *
     * @param index of workspace to switch to
     */
    void switchToWorkspace (int index);

    /**
     * deleted the specified workspace
     *
     * @param index workspace to delete
     */
    void closeWorkspace (int index);
}
