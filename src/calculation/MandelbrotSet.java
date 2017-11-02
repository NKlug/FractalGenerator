package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class MandelbrotSet extends AbstractSet {


    public MandelbrotSet(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public int converges(Complex start) {
        Complex zN = new Complex(0, 0);
        for (int i = 0; i < this.iterations; i++) {
            if (Complex.absolute(zN) > this.getRadius())
                return i;
            zN = Complex.add(Complex.multiply(zN, zN), start);
        }
        return iterations;
    }

    @Override
    public double getRadius() {
        return 2;
    }

    @Override
    public ZoomedImage calculateBufferedImage(int width, int height, Point2D origin, double scale) {
        ZoomedImage image = new ZoomedImage(width, height, BufferedImage.TYPE_3BYTE_BGR, scale);
        scale /= 1.5;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int breakIterations = this.converges(new Complex((i - 2 * width / 3) * scale - origin.getX(),
                        (j - height / 2) * scale - origin.getY()));
                if (breakIterations == iterations) {
                    image.setRGB(i, height - 1 - j, Color.WHITE.getRGB());
//                    image.setRGB(i, j, Color.BLACK.getRGB());
                } else {
                    image.setRGB(i, height - 1 - j, this.calculateColorFromNatural(breakIterations).getRGB());
//                    image.setRGB(i, j, Color.WHITE.getRGB());
                }
            }
        }
        return image;
    }
}
