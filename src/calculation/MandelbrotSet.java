package calculation;

import java.awt.event.ComponentListener;

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
    public void fillArray(byte[][][] image, int width, int height, double zoom) {
        int offsetX = width / 2;
        int offsetY = height / 2;
        double scale = this.getRadius() / Math.min(offsetX, offsetY);
        scale /= zoom;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!this.converges(new Complex((j - offsetX) * scale, (i - offsetY) * scale))) {
                    image[i][j][0] = 0;
                    image[i][j][1] = 0;
                    image[i][j][2] = 0;
//                    image[height - 1 - i][j][0] = 0;
//                    image[height - 1 - i][j][1] = 0;
//                    image[height - 1 - i][j][2] = 0;
                } else {
                    image[i][j][0] = (byte) 255;
                    image[i][j][1] = (byte) 255;
                    image[i][j][2] = (byte) 255;
//                    image[height - 1 - i][j][0] = (byte) 255;
//                    image[height - 1 - i][j][1] = (byte) 255;
//                    image[height - 1 - i][j][2] = (byte) 255;
                }
            }
        }
    }
}
