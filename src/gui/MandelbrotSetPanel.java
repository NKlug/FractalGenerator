package gui;

import calculation.MandelbrotSet;

import javax.swing.*;
import java.awt.*;

public class MandelbrotSetPanel extends JPanel {

    private ZoomPanel zoomPanel;
    private ImagePanel imagePanel;

    public MandelbrotSetPanel() {
        this.setLayout(new BorderLayout());

        this.imagePanel = new ImagePanel();
        this.zoomPanel = new ZoomPanel(imagePanel);

        this.add(zoomPanel, BorderLayout.PAGE_START);
        this.add(imagePanel, BorderLayout.CENTER);

        this.imagePanel.setSet(new MandelbrotSet());
    }
}
