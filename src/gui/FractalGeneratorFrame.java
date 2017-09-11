package gui;

import calculation.Complex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalGeneratorFrame extends JFrame {

    private JTabbedPane tabbedPane;
    
    private JPanel juliaSetPanel;
    private JPanel mandelbrotSetPanel;

    private JLabel errorLabel;



    public FractalGeneratorFrame() {
        this.setLocation(500, 300);
        this.setTitle("Fractal Generator");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.juliaSetPanel = new JuliaSetPanel(this);
        this.mandelbrotSetPanel = new MandelbrotSetPanel();

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Julia Set", juliaSetPanel);
        tabbedPane.addTab("Mandelbrot Set", mandelbrotSetPanel);

        this.add(tabbedPane, BorderLayout.CENTER);

        errorLabel = new JLabel();
        this.add(errorLabel, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);
    }


    public void setErrorText(String s) {
        this.errorLabel.setText(s);
    }

    public static void main(String[] args) {
        new FractalGeneratorFrame();
    }

}
