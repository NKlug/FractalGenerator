package gui;

import calculation.MandelbrotSet;

import javax.swing.*;
import java.awt.*;

public class MandelbrotSetPanel extends SetPanel {

    private JPanel selectionPanel;
    private JPanel controlPanel;

    private JLabel iterationsLabel;

    private JTextField iterationsTextField;

    private JButton showButton;

    public MandelbrotSetPanel(FractalGeneratorFrame parent) {
        super(parent);
        this.setLayout(new BorderLayout());

        this.selectionPanel = new JPanel();
        this.controlPanel = new JPanel(new BorderLayout());

        this.iterationsLabel = new JLabel("iterations");

        this.iterationsTextField = new JTextField("100");
        this.iterationsTextField.setPreferredSize(new Dimension(100, 30));

        this.showButton = new JButton("Show");
        this.showButton.addActionListener(e -> {
            this.showSet();
        });

        this.selectionPanel.add(iterationsLabel);
        this.selectionPanel.add(iterationsTextField);
        this.selectionPanel.add(showButton);

        this.controlPanel.add(selectionPanel, BorderLayout.PAGE_START);
        this.controlPanel.add(zoomPanel, BorderLayout.PAGE_END);

        this.add(controlPanel, BorderLayout.PAGE_START);
        this.add(imagePanel, BorderLayout.CENTER);

        this.showSet();
    }

    private void showSet() {
        try {
            int iterations = Integer.parseInt(this.iterationsTextField.getText());
            this.imagePanel.setSet(new MandelbrotSet(iterations));
            parent.setErrorText("");
        } catch (NumberFormatException ne) {
            parent.setErrorText(ne.getMessage());
        }

    }
}
