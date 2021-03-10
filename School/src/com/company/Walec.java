package com.company;

public class Walec {

    double r;
    double h;

    public Walec(double _r, double _h) {
        r = _r;
        h = _h;
    }

    public double getVolume() {
        return Math.PI * Math.pow(r, 2) * h;
    }
}
