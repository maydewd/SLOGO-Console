package model;

public class Line {

    private Point myStart;
    private Point myEnd;
    private boolean myVisibility;

    public Line (Point start, Point end, boolean visible) {
        setStart(start);
        setEnd(end);
        setVisibility(visible);
    }

    public Point getStart () {
        return myStart;
    }

    public void setStart (Point start) {
        myStart = start;
    }

    public Point getEnd () {
        return myEnd;
    }

    public void setEnd (Point end) {
        myEnd = end;
    }
    
    public void setVisibility (boolean v) {
    	myVisibility = v;
    }
    
    public boolean getVisibility () {
    	return myVisibility;
    }

}
