package ui;

public class Delta {	
	int oldX;
	int oldY;
	int newX;
	int newY;
	boolean line;
	public Delta(int ox, int oy, int nx, int ny, boolean l){
		oldX = ox;
		oldY = oy;
		newX = nx;
		newY = ny;
		line = l;
	}
	
	public int getOldX(){
		return oldX;
	}
	public int getOldY(){
		return oldY;
	}
	public int getNewX(){
		return newX;
	}
	public int getNewY(){
		return newY;
	}
	public boolean getLine(){
		return line;
	}
}
