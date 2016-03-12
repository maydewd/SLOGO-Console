package model;

import java.io.File;
import controller.configurations.ConfigurationException;


public interface IAdvancedModelManager extends IAdvancedModel {

    void createNewWorkspace ();

    void loadNewWorkspace (File xmlConfigFile) throws ConfigurationException;

    void switchToWorkspace (int index);

    void closeWorkspace (int index);
}
