package gui;

import javax.swing.*;
import java.awt.*;

public abstract class SetPanel extends JPanel {

    protected ZoomPanel zoomPanel;
    protected ImagePanel imagePanel;

    protected FractalGeneratorFrame parent;

    protected SetPanel (FractalGeneratorFrame parent) {
        this.parent = parent;
        this.imagePanel = new ImagePanel(parent);
        this.zoomPanel = new ZoomPanel(imagePanel);
    };
}
