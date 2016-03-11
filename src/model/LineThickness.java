package model;

public class LineThickness {
    
    private String myName;
    private double myThickness;

    public LineThickness (String name, double thickness) {
        setMyName(name);
        setMyThickness(thickness);
    }

    public String getMyName () {
        return myName;
    }

    private void setMyName (String myName) {
        this.myName = myName;
    }

    public double getMyThickness () {
        return myThickness;
    }

    private void setMyThickness (double myThickness) {
        this.myThickness = myThickness;
    }

}
