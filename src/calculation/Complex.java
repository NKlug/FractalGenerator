package calculation;

public class Complex {

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double real() {
        return this.real;
    }

    public double imaginary() {
        return this.imaginary;
    }

    public static Complex add(Complex z1, Complex z2) {
        return new Complex(z1.real() + z2.real(), z1.imaginary() + z2.imaginary());
    }

    public static Complex multiply(Complex z1, Complex z2) {
        return new Complex(z1.real()*z2.real() - z1.imaginary()*z2.imaginary(), z1.real()*z2.imaginary() + z1.imaginary()*z2.real());
    }

    public static double absolute(Complex z) {
        return Math.sqrt(z.real() * z.real() + z.imaginary() * z.imaginary());
    }

}
