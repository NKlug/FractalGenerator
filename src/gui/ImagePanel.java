package gui;

import calculation.AbstractSet;
import calculation.Complex;
import calculation.JuliaSet;
import calculation.MandelbrotSet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class ImagePanel extends JPanel {

    private AbstractSet set;
    private double zoom;

    private byte image[][][];
    private int imageHeight;
    private int imageWidth;

    public ImagePanel() {
        this.setPreferredSize(new Dimension(AbstractSet.SIZE, AbstractSet.SIZE));
        this.zoom = 1;
        this.imageHeight = AbstractSet.SIZE;
        this.imageWidth = AbstractSet.SIZE;
        this.image = new byte[this.imageHeight][this.imageWidth][3];
    }

    public void setSet(AbstractSet set) {
        this.set = set;
        this.repaint();
    }

    public void zoomIn() {
        zoom *= 1.5;
        this.repaint();
    }

    public void zoomOut() {
        zoom /= 1.5;
        this.repaint();
    }



    @Override
    public void paintComponent(Graphics g) {
        if (set != null) {

            set.fillArray(image, AbstractSet.SIZE, AbstractSet.SIZE, zoom);

            byte[] flatImage = new byte[imageWidth * imageHeight * 3];

            for (int i = 0; i < imageHeight; i++) {
                for (int j = 0; j < imageWidth; j++) {
                    flatImage[i * imageWidth + j*3] = image[i][j][0];
                    flatImage[i * imageWidth + j*3 + 1] = image[i][j][1];
                    flatImage[i * imageWidth + j*3 + 2] = image[i][j][2];
                }
            }

            for (int i = 0; i < imageHeight; i++) {
                for (int j = 0; j < imageWidth; j++) {
                    if (i < imageWidth/2) {
                        flatImage[i * imageWidth + j * 3] = (byte) 255;
                        flatImage[i * imageWidth + j*3 + 1] = (byte) 255;
                        flatImage[i * imageWidth + j*3 + 2] = (byte) 255;

                    }
                }
            }

            DataBuffer buffer = new DataBufferByte(flatImage, flatImage.length);

            WritableRaster raster = Raster.createInterleavedRaster(buffer, imageWidth, imageHeight, imageWidth*3, 3, new int[] {0, 1, 2}, (Point)null);
            ColorModel cm = new ComponentColorModel(ColorModel.getRGBdefault().getColorSpace(), false, true, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
            BufferedImage image = new BufferedImage(cm, raster, true, null);


            g.drawImage(image, 0, 0, this);
        }
    }
}
