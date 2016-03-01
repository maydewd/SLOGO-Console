package model;

public class RGBColor {

    private int myRed;
    private int myGreen;
    private int myBlue;

    public RGBColor (int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public int getRed () {
        return myRed;
    }

    private void setRed (int red) {
        if (red > 255 || red < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myRed = red;
    }

    public int getGreen () {
        return myGreen;
    }

    private void setGreen (int green) {
        if (green > 255 || green < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myGreen = green;
    }

    public int getBlue () {
        return myBlue;
    }

    private void setBlue (int blue) {
        if (blue > 255 || blue < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myBlue = blue;
    }
}
