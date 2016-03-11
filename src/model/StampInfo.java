package model;

public class StampInfo {
    private Point myLocation;
    private int myImageIndex;
    
    public StampInfo (Point location, int imageIndex) {
    	myLocation = location;
    }
    
    public Point getLocation (){
        return myLocation;
    }
    
    public int getImageIndex () {
        return myImageIndex;
    }

}
