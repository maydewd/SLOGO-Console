package model;

public class LineInfo {

    private Point myStart;
    private Point myEnd;
    private boolean myVisibility;
    private RGBColor myColor;
    
    public LineInfo (Point start, Point end, boolean visible, RGBColor color) {
        setStart(start);
        setEnd(end);
        setVisibility(visible);
        setColor(color);
    }

    public Point getStart () {
        return myStart;
    }

    private void setStart (Point start) {
        myStart = start;
    }

    public Point getEnd () {
        return myEnd;
    }

    private void setEnd (Point end) {
        myEnd = end;
    }
    
    public boolean getVisibility () {
        return myVisibility;
    }
    
    private void setVisibility (boolean v) {
    	myVisibility = v;
    }

    public RGBColor getColor () {
        return myColor;
    }

    private void setColor (RGBColor color) {
        myColor = color;
    }

}
