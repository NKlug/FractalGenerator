package calculation;

import gui.ZoomedImage;

public abstract class AbstractSet  {

    public static int ITERATIONS = 100;
    public static int SIZE = 500;

    public abstract boolean converges(Complex start);
    public abstract double getRadius();
    public abstract ZoomedImage calculateBufferedImage(int width, int height, double zoom);

}
