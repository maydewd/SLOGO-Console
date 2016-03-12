package controller.configurations;

import java.util.List;


public class Configuration {

    private String backgroundIndex;
    private List<String> imageList;
    private String turtleCount;
    private String languageIndex;
    
    public Configuration (String backgroundIndex, List<String> imageFiles, String turtleCount, String languageIndex) {
        setBackgroundIndex(backgroundIndex);
        setImageList(imageFiles);
        setTurtleCount(turtleCount);
        setLanguageIndex(languageIndex);
    }

    public String getBackgroundIndex () {
        return backgroundIndex;
    }

    private void setBackgroundIndex (String backgroundIndex) {
        this.backgroundIndex = backgroundIndex;
    }

    public List<String> getImageList () {
        return imageList;
    }

    private void setImageList (List<String> imageList) {
        this.imageList = imageList;
    }

    public String getTurtleCount () {
        return turtleCount;
    }

    private void setTurtleCount (String turtleCount) {
        this.turtleCount = turtleCount;
    }

    public String getLanguageIndex () {
        return languageIndex;
    }

    private void setLanguageIndex (String languageIndex) {
        this.languageIndex = languageIndex;
    }

}
