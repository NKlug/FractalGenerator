package gui;

import calculation.MandelbrotSet;

import javax.swing.*;
import java.awt.*;

public class MandelbrotSetPanel extends SetPanel {

    public MandelbrotSetPanel(FractalGeneratorFrame parent) {
        super(parent);
        this.setLayout(new BorderLayout());

        this.add(zoomPanel, BorderLayout.PAGE_START);
        this.add(imagePanel, BorderLayout.CENTER);

        this.imagePanel.setSet(new MandelbrotSet());
    }
}
