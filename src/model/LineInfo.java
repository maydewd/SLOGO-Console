package model;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

public class LineInfo {
    
    private static final double DEFAULT_THICKNESS = 1.0d;
    private static final LineType DEFAULT_TYPE = LineType.SOLID;

    private Point myStart;
    private Point myEnd;
    private boolean myVisibility;
    private int myColor;
    private double myThickness;
    private LineType myType;
    
    public LineInfo (Point start, Point end, boolean visible, int color) {
        this(start, end, visible, color, DEFAULT_THICKNESS, DEFAULT_TYPE);
    }
    
    public LineInfo (Point start, Point end, boolean visible, int color, double thickness, LineType lineType) {
        setStart(start);
        setEnd(end);
        setVisibility(visible);
        setColor(color);
    	setThickness(thickness);
    	setType(lineType);
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
    
    private void setType (LineType lineType) {
    	myType = lineType;
  		
  	}

    public LineType getTypeIndex () {
    	return myType;
    }

}
