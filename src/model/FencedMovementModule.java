package model;

import view.TurtleView;


public class FencedMovementModule extends WindowMovementModule {
    
    public FencedMovementModule (WindowMovementModule module) {
        super(module);
        setLocation(getLocation());
    }

    @Override
    public void setLocation (Point location) {
        super.setLocation(fencePoint(location));
    }

    private Point fencePoint (Point point) {
        double fencedX = Math.max(getMinX(), Math.min(getMaxX(), point.getX()));
        double fencedY = Math.max(getMinY(), Math.min(getMaxY(), point.getY()));
        return new Point(fencedX, fencedY);
    }
    
    private double getMinX () {
        return -TurtleView.DEFAULT_WIDTH/2;
    }
    
    private double getMinY () {
        return -TurtleView.DEFAULT_HEIGHT/2;
    }

    private double getMaxX () {
        return TurtleView.DEFAULT_WIDTH/2;
    }

    private double getMaxY () {
        return TurtleView.DEFAULT_HEIGHT/2;
    }
}
