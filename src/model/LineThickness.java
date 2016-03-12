package model;

public enum LineThickness {
                           SMALL(0.5d),
                           MEDIUM(1.0d),
                           LARGE(3.0d);

    private double myThickness;

    LineThickness (double thickness) {
        myThickness = thickness;
    }

    public double getMyThickness () {
        return myThickness;
    }

}
