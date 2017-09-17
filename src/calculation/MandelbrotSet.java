package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class MandelbrotSet extends AbstractSet {


    public MandelbrotSet() {
    }

    @Override
    public boolean converges(Complex start) {
        Complex zN = new Complex(0, 0);
        for (int i = 0; i < AbstractSet.ITERATIONS; i++) {
            if (Complex.absolute(zN) > this.getRadius())
                return false;
            zN = Complex.add(Complex.multiply(zN, zN), start);
        }
        return true;
    }

    @Override
    public double getRadius() {
        return 2;
    }

    @Override
    public ZoomedImage calculateBufferedImage(int width, int height, Point origin, double zoom) {
        ZoomedImage image = new ZoomedImage(width, height, BufferedImage.TYPE_3BYTE_BGR, zoom);
        double scale = ((2* this.getRadius()) / Math.min(width, height)) / 1.5;
        scale /= zoom;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!this.converges(new Complex((i - origin.getX()) * scale, (j - origin.getY()) * scale))) {
                    image.setRGB(i, height - 1 - j, Color.BLACK.getRGB());
//                    image.setRGB(i, j, Color.BLACK.getRGB());
                } else {
                    image.setRGB(i, height - 1 - j, Color.WHITE.getRGB());
//                    image.setRGB(i, j, Color.WHITE.getRGB());
                }
            }
        }
        return image;
    }
}
