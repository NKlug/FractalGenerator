package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class AbstractSet  {

    protected int iterations = 100;

    public abstract boolean converges(Complex start);
    public abstract double getRadius();
    public abstract ZoomedImage calculateBufferedImage(int width, int height, Point2D origin, double zoom);

}
