package calculation;

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

    @Override
    public void fillArray(byte[][][] image, int width, int height, double zoom) {
        /*int offsetX = AbstractSet.SIZE / 2;
        int offsetY = AbstractSet.SIZE / 2;
        double scale = this.getRadius() / Math.min(offsetX, offsetY);
        scale /= zoom;

        for (int i = 0; i <= height/2; i++) {
            for (int j = 0; j < width; j+=3) {
                int offset = i * width + j;
                if (this.converges(new Complex((i - offsetX) * scale, (j - offsetY) * scale))) {
                    image[offset] = 0;
                    image[offset + 1] = 0;
                    image[offset + 2] = 0;
                    offset = (width * height) - 1 - offset;
                    image[offset] = 0;
                    image[offset + 1] = 0;
                    image[offset + 2] = 0;
                } else {
                    image[offset] = (byte) 255;
                    image[offset + 1] = (byte) 255;
                    image[offset + 2] = (byte) 255;
                    offset = width * height - 1 - offset;
                    image[offset] = (byte) 255;
                    image[offset + 1] = (byte) 255;
                    image[offset + 2] = (byte) 255;
                }
            }
        }*/
    }

}

