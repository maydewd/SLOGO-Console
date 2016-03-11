package model;

public enum LineType {
    SOLID(1, 0),
    DASHED(15, 15),
    DOTTED(1, 10);
    
    private double myPixelsOn;
    private double myPixelsOff;
    
    LineType (double pixelsOn, double pixelsOff) {
        myPixelsOn = pixelsOn;
        myPixelsOff = pixelsOff;
    }
   

    public double getPixelsOn () {
        return myPixelsOn;
    }


    public double getPixelsOff () {
        return myPixelsOff;
    }


    

}
