package com.company.dziedziczenie;

public class Konto {
    public String name;
    public float money = 200;
    public int number;

    public Konto(String _name, int _number) {
        name = _name;
        number = _number;
    }
    public void przelew(Konto konto, int amount) {
        konto.money += amount;
        money -= amount;
    }
}
