package gui;

import calculation.Complex;
import calculation.JuliaSet;

import javax.swing.*;
import java.awt.*;

public class JuliaSetPanel extends SetPanel {

    private JPanel selectionPanel;
    private JPanel controlPanel;

    private JLabel realLabel;
    private JLabel imaginaryLabel;

    private JTextField realTextField;
    private JTextField imaginaryTextField;

    private JButton startButton;

    public JuliaSetPanel(FractalGeneratorFrame parent) {
        super(parent);
        this.setLayout(new BorderLayout());

        this.selectionPanel = new JPanel();

        this.controlPanel = new JPanel();
        this.controlPanel.setLayout(new BorderLayout());

        this.realLabel = new JLabel("real");
        this.imaginaryLabel = new JLabel("imaginary");

        this.realTextField = new JTextField("0.0");
        this.realTextField.setPreferredSize(new Dimension(100, 30));
        this.imaginaryTextField = new JTextField("0.0");
        this.imaginaryTextField.setPreferredSize(new Dimension(100, 30));


        this.startButton = new JButton("Show");
        this.startButton.addActionListener(e -> {
            try {
                Complex c = new Complex(Double.parseDouble(realTextField.getText()),
                        Double.parseDouble(imaginaryTextField.getText()));
                imagePanel.setSet(new JuliaSet(c));
                parent.pack();
                parent.setErrorText("");
            } catch (NumberFormatException ne) {
                parent.setErrorText(ne.getMessage());
            }
        });

        this.selectionPanel.add(realLabel);
        this.selectionPanel.add(realTextField);
        this.selectionPanel.add(imaginaryLabel);
        this.selectionPanel.add(imaginaryTextField);
        this.selectionPanel.add(startButton);

        this.controlPanel.add(selectionPanel, BorderLayout.PAGE_START);
        this.controlPanel.add(zoomPanel, BorderLayout.PAGE_END);

        this.add(controlPanel, BorderLayout.PAGE_START);
        this.add(imagePanel, BorderLayout.CENTER);

        this.startButton.doClick();
    }

}
