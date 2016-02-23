package model;

public class Delta {
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;
	private boolean isPenDown;

	public Delta(int ox, int oy, int nx, int ny, boolean l) {
		oldX = ox;
		oldY = oy;
		newX = nx;
		newY = ny;
		isPenDown = l;
	}

	public int getOldX() {
		return oldX;
	}

	public int getOldY() {
		return oldY;
	}

	public int getNewX() {
		return newX;
	}

	public int getNewY() {
		return newY;
	}

	public boolean getPenDown() {
		return isPenDown;
	}
}
