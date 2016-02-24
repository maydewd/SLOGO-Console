package model;

public class Line {

    private Point myStart;
    private Point myEnd;

    public Line (Point start, Point end) {
        setStart(start);
        setEnd(end);
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

}
