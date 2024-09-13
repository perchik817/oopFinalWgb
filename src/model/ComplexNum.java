package model;

public class ComplexNum {
    private double real;
    private double imaginary;

    public ComplexNum(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public boolean isReal() {
        return imaginary == 0;
    }

    public boolean isImaginary() {
        return real == 0 && imaginary != 0;
    }

    public boolean isComplex() {
        return real != 0 && imaginary != 0;
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}
