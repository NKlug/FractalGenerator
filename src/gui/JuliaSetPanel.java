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
    private JLabel iterationsLabel;

    private JTextField realTextField;
    private JTextField imaginaryTextField;
    private JTextField iterationsTextField;

    private JButton showButton;

    public JuliaSetPanel(FractalGeneratorFrame parent) {
        super(parent);
        this.setLayout(new BorderLayout());

        this.selectionPanel = new JPanel();

        this.controlPanel = new JPanel();
        this.controlPanel.setLayout(new BorderLayout());

        this.realLabel = new JLabel("real");
        this.imaginaryLabel = new JLabel("imaginary");
        this.iterationsLabel = new JLabel("iterations");

        this.realTextField = new JTextField("0.0");
        this.realTextField.setPreferredSize(new Dimension(100, 30));
        this.imaginaryTextField = new JTextField("0.0");
        this.imaginaryTextField.setPreferredSize(new Dimension(100, 30));
        this.iterationsTextField = new JTextField("30");
        this.iterationsTextField.setPreferredSize(new Dimension(100, 30));


        this.showButton = new JButton("Show");
        this.showButton.addActionListener(e -> {
            this.showSet();
        });

        this.selectionPanel.add(realLabel);
        this.selectionPanel.add(realTextField);
        this.selectionPanel.add(imaginaryLabel);
        this.selectionPanel.add(imaginaryTextField);
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
            Complex c = new Complex(Double.parseDouble(realTextField.getText()),
                    Double.parseDouble(imaginaryTextField.getText()));
            int iterations = Integer.parseInt(iterationsTextField.getText());

            imagePanel.setSet(new JuliaSet(c, iterations));
            parent.pack();
            parent.setErrorText("");
        } catch (NumberFormatException ne) {
            parent.setErrorText(ne.getMessage());
        }

    }

}
