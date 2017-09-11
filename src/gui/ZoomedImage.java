package gui;

import java.awt.image.BufferedImage;

public class ZoomedImage extends BufferedImage {

    private double zoom;

    public ZoomedImage(int width, int height, int imageType, double zoom) {
        super(width, height, imageType);
        this.zoom = zoom;

    }

    public double getZoom() {
        return zoom;
    }
}
