package calculation;

import gui.ZoomedImage;

import java.awt.*;

public abstract class AbstractSet  {

    public static int ITERATIONS = 30;

    public abstract boolean converges(Complex start);
    public abstract double getRadius();
    public abstract ZoomedImage calculateBufferedImage(int width, int height, Point origin, double zoom);

}
