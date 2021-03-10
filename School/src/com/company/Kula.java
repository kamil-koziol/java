package com.company;

public class Kula {

    double r;

    public Kula(double _r) {
        r = _r;
    }

    public double getVolume() {
        return 4.0/3.0 * Math.PI * Math.pow(r, 3);
    }

}
