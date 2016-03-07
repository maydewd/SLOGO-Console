package controller;

import java.io.File;

public interface IParserController {
    void saveWorkspace(File file);
    
    void loadWorkspace(File file);
}
