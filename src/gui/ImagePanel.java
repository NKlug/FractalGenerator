package gui;

import calculation.AbstractSet;
import calculation.Complex;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImagePanel extends JPanel {

    private AbstractSet set;
    private int imageHeight;
    private int imageWidth;
    private double zoom;

    private ZoomedImage image;

    private Point origin;
    private Point dragStart;

    private FractalGeneratorFrame parent;


    public ImagePanel(FractalGeneratorFrame parent) {
        this.parent = parent;
        this.imageHeight = 600;
        this.imageWidth = 600;
        this.setPreferredSize(new Dimension(imageWidth, imageHeight));
        this.zoom = 1;

        origin = new Point(imageWidth / 2, imageHeight / 2);
        dragStart = new Point();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = new Point(e.getX(), e.getY());
            }

        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                origin.setLocation(origin.getX() + (e.getX() - dragStart.getX()), origin.getY() + (dragStart.getY() - e.getY()));
                dragStart.setLocation(e.getX(), e.getY());
                repaint();
            }
        });
    }

    public void setSet(AbstractSet set) {
        this.set = set;
        this.repaint();
    }

    public void zoomIn() {
        this.zoom *= 1.5;
        this.repaint();
        System.out.println(this.origin.toString());
    }

    public void zoomOut() {
        this.zoom /= 1.5;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.getWidth() != 0 && this.getHeight() != 0) {
            this.imageWidth = Math.min(this.getWidth(), this.getHeight());
            this.imageHeight = Math.min(this.getWidth(), this.getHeight());
        }

        if (this.set != null) {
//            if (this.image == null) {
//                this.image = set.calculateBufferedImage(this.imageWidth, this.imageHeight, origin, zoom);
//            } else if (this.imageWidth != this.getWidth() || this.imageHeight != this.getHeight()
//                    || this.zoom != image.getZoom()) {
//                this.imageWidth = Math.min(this.getWidth(), this.getHeight());
//                this.imageHeight = Math.min(this.getWidth(), this.getHeight());
//            }

//            double scale = (2 * this.set.getRadius()) / Math.min(this.imageWidth, this.imageHeight);
//
//            for (int i = 0; i < this.imageHeight; i++) {
//                for (int j = 0; j < this.imageWidth; j++) {
//                    if (this.set.converges(new Complex((i - this.imageWidth/2) * scale, (j - this.imageHeight/2) * scale))) {
//                        g.setColor(Color.WHITE);
//                        g.fillRect(i, this.imageHeight - j, 1, 1);
//                    } else {
//                        g.setColor(Color.BLACK);
//                        g.fillRect(i, this.imageHeight - j, 1, 1);
//                    }
//                }
//            }


            this.image = set.calculateBufferedImage(this.imageWidth, this.imageHeight, origin, zoom);
            g.drawImage(this.image, 0, 0, this);
        }
    }


    public ZoomedImage getImage() {
        return this.image;
    }
}
