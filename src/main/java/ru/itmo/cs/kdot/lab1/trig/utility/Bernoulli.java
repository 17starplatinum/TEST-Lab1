package ru.itmo.cs.kdot.lab1.trig.utility;

import org.apache.commons.math3.fraction.BigFraction;

public class Bernoulli {
    public static double calculateBernoulli(int n) {
        BigFraction[] A = new BigFraction[n + 1];
        for (int m = 0; m <= n; m++) {
            A[m] = new BigFraction(1, (m + 1));
            for (int j = m; j >= 1; j--)
                A[j - 1] = (A[j - 1].subtract(A[j])).multiply(new BigFraction(j));
        }
        return A[0].doubleValue();
    }
}
