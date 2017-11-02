package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class JuliaSet extends AbstractSet {

    private Complex c;

    private double radius;

    public JuliaSet(Complex c, int iterations) {
        this.c = c;
        this.iterations = iterations;
        this.initRadius();
    }

    private void initRadius() {
        this.radius = 0.5 + Math.sqrt(0.25 + Complex.absolute(this.c));
    }

    public int converges(Complex start) {
        Complex zN = start;
        for (int i = 0; i < this.iterations; i++) {
            if (Complex.absolute(zN) > this.getRadius())
                return i;
            zN = Complex.add(Complex.multiply(zN, zN), this.c);
        }
        return this.iterations;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public ZoomedImage calculateBufferedImage(int width, int height, Point2D origin, double scale) {
        ZoomedImage image = new ZoomedImage(width, height, BufferedImage.TYPE_3BYTE_BGR, scale);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int breakIterations = this.converges(new Complex((i - width/2) * scale - origin.getX(),
                        (j - height/2) * scale - origin.getY()));
                if (breakIterations == this.iterations) {
                    image.setRGB(i, height - 1 - j, Color.BLACK.getRGB());
//                    image.setRGB(width - 1 - i, j, Color.WHITE.getRGB());
                } else {
                    image.setRGB(i, height - 1 - j, this.calculateColorFromNatural(breakIterations).getRGB());
//                    image.setRGB(width - 1 - i, j, Color.BLACK.getRGB());
                }
            }
        }
//        for (int i = -2; i <= 2; i++)
//            for (int j = -2; j <= 2; j++)
//                image.setRGB((int)origin.getX()+i,(int)origin.getY()+j, Color.RED.getRGB());
        return image;
    }

}

