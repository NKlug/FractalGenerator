package gui;

import calculation.AbstractSet;

import javax.swing.*;
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


    public ImagePanel() {
        this.setPreferredSize(new Dimension(AbstractSet.SIZE, AbstractSet.SIZE));
        this.zoom = 1;
        this.imageHeight = AbstractSet.SIZE;
        this.imageWidth = AbstractSet.SIZE;

        origin = new Point(imageWidth/2, imageHeight/2);
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
                origin.setLocation(origin.getX() + (e.getX() - dragStart.getX()) , origin.getY() +(dragStart.getY() - e.getY()));
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
    }

    public void zoomOut() {
        this.zoom /= 1.5;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (set != null) {
//            if (image == null || this.imageWidth != this.getWidth() || this.imageHeight != this.getHeight() || this.zoom != image.getZoom())
                System.out.println(origin);
                this.image = set.calculateBufferedImage(this.imageWidth, this.imageHeight, origin, zoom);

            g.drawImage(this.image, 0, 0, this);
        }
    }
}
