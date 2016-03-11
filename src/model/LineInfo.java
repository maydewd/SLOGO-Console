package model;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

public class LineInfo {
    
    private static final double DEFAULT_THICKNESS = 1.0d;
    private static final int DEFAULT_TYPE_INDEX = 0;

    private Point myStart;
    private Point myEnd;
    private boolean myVisibility;
    private int myColor;
    private double myThickness;
    private int myTypeIndex;
    
    public LineInfo (Point start, Point end, boolean visible, int color) {
        this(start, end, visible, color, DEFAULT_THICKNESS, DEFAULT_TYPE_INDEX);
    }
    
    public LineInfo (Point start, Point end, boolean visible, int color, double thickness, int typeValue) {
        setStart(start);
        setEnd(end);
        setVisibility(visible);
        setColor(color);
    	setThickness(thickness);
    	setTypeIndex(typeValue);
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
    
    private void setThickness (double thickness) {
    	myThickness = thickness;
    }
    
    public double getThickness () {
    	return myThickness;
    }
    
    public void setTypeIndex (int typeValue) {
    	myTypeIndex = typeValue;
  		
  	}

    public int getTypeIndex () {
    	return myTypeIndex;
    }

}
