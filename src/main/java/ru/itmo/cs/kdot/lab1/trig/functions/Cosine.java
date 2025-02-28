package ru.itmo.cs.kdot.lab1.trig.functions;

import ru.itmo.cs.kdot.lab1.trig.AbstractTrigonometry;

public class Cosine extends AbstractTrigonometry {
    @Override
    public double calculate(double x, int terms) {
        if(terms < 1) {
            throw new IllegalArgumentException();
        }
        double res = 0d;
        for(int i = 0; i < terms; i++) {
            res += calculateTerm(x, i);
        }
        return res;
    }

    @Override
    protected double calculateTerm(double x, int k) {
        return calculatePower(-1, k) / calculateFactorial(2 * k) * calculatePower(x, 2 * k);
    }
}
