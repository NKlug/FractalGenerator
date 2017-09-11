package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class JuliaSet extends AbstractSet {

    private Complex c;

    private double radius;

    public JuliaSet(Complex c) {
        this.c = c;
        this.initRadius();
    }

    private void initRadius() {
        this.radius = 0.5 + Math.sqrt(0.25 + Complex.absolute(this.c));
    }

    public boolean converges(Complex start) {
        Complex zN = start;
        for (int i = 0; i < AbstractSet.ITERATIONS; i++) {
            if (Complex.absolute(zN) > this.getRadius())
                return false;
            zN = Complex.add(Complex.multiply(zN, zN), this.c);
        }
        return true;
    }

    public double getRadius() {
        return radius;
    }

    public ZoomedImage calculateBufferedImage(int width, int height, double zoom) {
        ZoomedImage image = new ZoomedImage(width, height, BufferedImage.TYPE_3BYTE_BGR, zoom);
        int offsetX = AbstractSet.SIZE / 2;
        int offsetY = AbstractSet.SIZE / 2;
        double scale = this.getRadius() / Math.min(offsetX, offsetY);
        scale /= zoom;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= height/2; j++) {
                if (this.converges(new Complex((i - offsetX) * scale, (j - offsetY) * scale))) {
                    image.setRGB(i, height - 1 - j, Color.WHITE.getRGB());
                    image.setRGB(width - 1 - i, j, Color.WHITE.getRGB());
                } else {
                    image.setRGB(i, height - 1 - j, Color.BLACK.getRGB());
                    image.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }
        return image;
    }

}

