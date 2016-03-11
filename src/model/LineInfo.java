package model;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

public class LineInfo {

    private Point myStart;
    private Point myEnd;
    private boolean myVisibility;
    private int myColor;
    private int myThickness;
    private Entry<Double, Double> myType;
    
    public LineInfo (Point start, Point end, boolean visible, int color) {
        setStart(start);
        setEnd(end);
        setVisibility(visible);
        setColor(color);
    }
    
    public LineInfo (Point start, Point end, boolean visible, int color, int thickness, Entry<Double, Double> typeValue) {
    	this(start, end, visible, color);
    	setThickness(thickness);
    	setType(typeValue);
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

    public int getColor () {
        return myColor;
    }

    private void setColor (int color) {
        myColor = color;
    }
    
    private void setThickness (int thickness) {
    	myThickness = thickness;
    }
    
    public double getThickness () {
    	return myThickness;
    }
    
    public void setType(Entry<Double, Double> typeValue) {
    	myType = typeValue;
  		
  	}

    public Entry<Double, Double> getType() {
    	return myType;
    }

}
