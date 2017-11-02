package calculation;

import gui.ZoomedImage;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class AbstractSet {

    protected int iterations = 100;

    private final double GAMMA = 0.80;
    private final double INTENSITY_MAX = 255;

    public abstract int converges(Complex start);

    public abstract double getRadius();

    public abstract ZoomedImage calculateBufferedImage(int width, int height, Point2D origin, double zoom);

    protected Color calculateColorFromNatural(int natural) {
//        return calculateColorFromWavelength(380 + natural * (400 / iterations));
        return calculateColor(natural * (255/iterations));
    }

    private Color calculateColor(int value) {
        return new Color(0, 255-value, 50);
    }


    private Color calculateColorFromWavelength(int wavelength) {
        /**
         * See http://www.efg2.com/Lab/ScienceAndEngineering/Spectra.htm
         */
        double factor;
        double red, green, blue;

        if ((wavelength >= 380) && (wavelength < 440)) {
            red = -(wavelength - 440) / (440 - 380);
            green = 0.0;
            blue = 1.0;
        } else if ((wavelength >= 440) && (wavelength < 490)) {
            red = 0.0;
            green = (wavelength - 440) / (490 - 440);
            blue = 1.0;
        } else if ((wavelength >= 490) && (wavelength < 510)) {
            red = 0.0;
            green = 1.0;
            blue = -(wavelength - 510) / (510 - 490);
        } else if ((wavelength >= 510) && (wavelength < 580)) {
            red = (wavelength - 510) / (580 - 510);
            green = 1.0;
            blue = 0.0;
        } else if ((wavelength >= 580) && (wavelength < 645)) {
            red = 1.0;
            green = -(wavelength - 645) / (645 - 580);
            blue = 0.0;
        } else if ((wavelength >= 645) && (wavelength < 781)) {
            red = 1.0;
            green = 0.0;
            blue = 0.0;
        } else {
            red = 0.0;
            green = 0.0;
            blue = 0.0;
        }

        if ((wavelength >= 380) && (wavelength < 420)) {
            factor = 0.3 + 0.7 * (wavelength - 380) / (420 - 380);
        } else if ((wavelength >= 420) && (wavelength < 701)) {
            factor = 1.0;
        } else if ((wavelength >= 701) && (wavelength < 781)) {
            factor = 0.3 + 0.7 * (780 - wavelength) / (780 - 700);
        } else {
            factor = 0.0;
        }

        red = (red == 0.0) ? 0 : (int) Math.round(INTENSITY_MAX * Math.pow(red * factor, GAMMA));
        green = (green == 0.0) ? 0 : (int) Math.round(INTENSITY_MAX * Math.pow(green * factor, GAMMA));
        blue = (blue == 0.0) ? 0 : (int) Math.round(INTENSITY_MAX * Math.pow(blue * factor, GAMMA));

        return new Color((int) red, (int) green, (int) blue);
    }
}
