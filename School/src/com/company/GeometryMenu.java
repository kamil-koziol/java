package com.company;

import java.util.Scanner;

public class GeometryMenu {

    private final Scanner scanner;

    public GeometryMenu() {
        scanner = new Scanner(System.in);
    }

    void show() {
        System.out.println("======== MENU ========");
        System.out.println("1. Objętość Kuli");
        System.out.println("2. Objętość Walca");
        System.out.println("======================");
    }

    int getChoice() {
        System.out.println("Twój wybór: ");
        return scanner.nextInt();
    }

    void processMenu(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("Podaj promień:");
                double r = scanner.nextDouble();

                Kula kula = new Kula(r);
                System.out.println(kula.getVolume());
            }

            case 2 -> {
                System.out.println("Podaj promień:");
                double r = scanner.nextDouble();
                System.out.println("Podaj wysokość:");
                double h = scanner.nextDouble();

                Walec walec = new Walec(r, h);
                System.out.println(walec.getVolume());
            }
        }
    }

    public static void main() {
        GeometryMenu menu = new GeometryMenu();
        menu.show();
        int choice = menu.getChoice();
        menu.processMenu(choice);
    }
}
