package ru.itmo.cs.kdot.lab1.trig;

public abstract class AbstractTrigonometry {
    public abstract double calculate(double x, int terms);

    protected abstract double calculateTerm(double x, int k);

    protected double calculatePower(double base, int exponent) {
        double res = 1.0d;
        for(int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }

    protected double calculateFactorial(int n) {
        if(n == 0) return 1;
        return n * calculateFactorial(n - 1);
    }
}
