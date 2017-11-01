package gui;

import calculation.AbstractSet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZoomPanel extends JPanel {

    private JButton zoomIn;
    private JButton zoomOut;
    private JButton saveImage;

    private ImagePanel panel;


    public ZoomPanel(ImagePanel panel) {
        this.setLayout(new BorderLayout());

        this.panel = panel;
        this.zoomIn = new JButton("+");
        this.zoomOut = new JButton("-");
        this.saveImage = new JButton("Save");

        zoomIn = new JButton("+");
        zoomIn.addActionListener(e -> {
            this.panel.zoomIn();

        });
        zoomOut = new JButton("-");
        zoomOut.addActionListener(e -> {
            this.panel.zoomOut();

        });

        saveImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    ImageIO.write(this.panel.getImage(), "png", file);
                } catch (IOException fe) {
                }
            }
        });

        JPanel zoomButtons = new JPanel();
        zoomButtons.add(this.zoomOut);
        zoomButtons.add(this.zoomIn);

        this.add(zoomButtons, BorderLayout.CENTER);
        this.add(saveImage, BorderLayout.LINE_END);
    }

}
