package hus.oop.lab4.shapes;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(){

    }
    public MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public String toString(){
        return "(" + real + " + " + imag + "i)";
    }

    public boolean isReal(){
        return imag == 0;
    }

    public boolean isImaginary(){
        return real == 0;
    }

    public boolean equals(double real, double imag){
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another){
        return (this.real == another.real && this.imag == another.imag);
    }

    public double magnitude(){
        return Math.sqrt(real * real + imag * imag);
    }

    public MyComplex addInto(MyComplex right){
        this.real = real + right.real;
        this.imag = imag + right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right){
        double resultReal = this.real + right.real;
        double resultImag = this.imag + right.imag;
        return new MyComplex(resultReal, resultImag);
    }

    public MyComplex subtract(MyComplex right){
        this.real = real - right.real;
        this.imag = imag - right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        double resultReal = this.real - right.real;
        double resultImag = this.imag - right.imag;
        return new MyComplex(resultReal, resultImag);
    }

    public MyComplex multiply(MyComplex right){
        double resultReal = real * right.real - imag * right.imag;
        double resultImag = real * right.imag + imag * right.real;
        return new MyComplex(resultReal, resultImag);
    }

    public MyComplex divide(MyComplex right){
        double a = this.real;
        double b = this.imag;

        double c = right.real;
        double d = right.imag;

        double denominator = c * c + d * d;

        double realPart = (a * c + b * d) / denominator;
        double imagPart = (b * c - a * d) / denominator;
        return new MyComplex(realPart, imagPart);
    }

    public double argument(){
        return Math.atan2(imag, real);
    }

    public MyComplex conjugate(){
        double resultImag = this.imag * -1;
        return new MyComplex(real, resultImag);
    }

}

