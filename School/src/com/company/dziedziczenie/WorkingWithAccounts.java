package com.company.dziedziczenie;

public class WorkingWithAccounts {
    public static void main() {
        Konto konto = new Konto("Kamil", 1);
        Konto konto2 = new Konto("Marcin", 2);
        KontoPremium kontoPremium = new KontoPremium("Patryk", 3);

        konto.przelew(konto2, 100);
        System.out.println(konto2.money);

        konto.przelew(kontoPremium, 200);
        System.out.println(kontoPremium.money);
        System.out.println(konto.money);
    }
}
