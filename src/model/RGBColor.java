package model;

public class RGBColor {
    
    private int red;
    private int green;
    private int blue;
    
    public RGBColor(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public int getRed () {
        return red;
    }

    private void setRed (int red) {
        this.red = red;
    }

    public int getGreen () {
        return green;
    }

    private void setGreen (int green) {
        this.green = green;
    }

    public int getBlue () {
        return blue;
    }

    private void setBlue (int blue) {
        this.blue = blue;
    }
}
