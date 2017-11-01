package calculation;

import gui.ZoomedImage;

import java.awt.*;

public abstract class AbstractSet  {

    protected int iterations = 30;

    public abstract boolean converges(Complex start);
    public abstract double getRadius();
    public abstract ZoomedImage calculateBufferedImage(int width, int height, Point origin, double zoom);

}
