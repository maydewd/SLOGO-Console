package model;

public class StampInfo {
    private Point myLocation;
    
    public StampInfo (Point location) {
    	myLocation = location;
    }
    
	public Point getLocation (){
        return myLocation;
    }

}
