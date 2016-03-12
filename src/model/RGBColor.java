package model;


public class RGBColor {
	
	private static final int MAX_SATURATION = 255;

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
        if (red > MAX_SATURATION || red < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myRed = red;
    }

    public int getGreen () {
        return myGreen;
    }

    private void setGreen (int green) {
        if (green > MAX_SATURATION || green < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myGreen = green;
    }

    public int getBlue () {
        return myBlue;
    }

    private void setBlue (int blue) {
        if (blue > MAX_SATURATION || blue < 0) {
            // TODO add message
            throw new IllegalArgumentException();
        }
        myBlue = blue;
    }

    @Override
    public String toString () {
        String redHex = String.format("%2s", Integer.toHexString(getRed())).replace(" ", "0");
        String greenHex = String.format("%2s", Integer.toHexString(getGreen())).replace(" ", "0");
        String blueHex = String.format("%2s", Integer.toHexString(getBlue())).replace(" ", "0");
        return new StringBuilder().append(redHex).append(greenHex).append(blueHex).toString();
    }
    
    
}
