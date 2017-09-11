package gui;

import java.awt.image.BufferedImage;

public class ZoomableImage extends BufferedImage {


    private double zoom;

    public ZoomableImage(int width, int height, int imageType, double zoom) {
        super(width, height, imageType);
        this.zoom = zoom

    }
    public void zoomIn() {
        zoom *= 1.5;
    }

    public void zoomOut() {
        zoom /= 1.5;
    }


    public double getZoom() {
        return zoom;
    }
}
