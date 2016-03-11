package model;

import java.io.File;

public interface IAdvancedModelManager extends IAdvancedModel {

    void createNewWorkspace();
    
    void loadNewWorkspace(File xmlConfigFile);
    
    void switchToWorkspace(int index);
    
    void closeWorkspace(int index);
}
