package gui;

import calculation.AbstractSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomPanel extends JPanel {

    private JButton zoomIn;
    private JButton zoomOut;

    private ImagePanel panel;

    public ZoomPanel(ImagePanel panel) {
        this.panel = panel;
        this.zoomIn = new JButton("+");
        this.zoomOut = new JButton("-");

        zoomIn = new JButton("+");
        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.zoomIn();
            }
        });
        zoomOut = new JButton("-");
        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.zoomOut();
            }
        });

        this.add(this.zoomOut);
        this.add(this.zoomIn);
    }

}
