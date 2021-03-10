package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class WorkingWithArrays {
    public static void main() {
        char[] znaki = new char[3];
        int[] liczby = new int[20];

        String test = "Witam wszystkich bardzo serdecznie";
        znaki = test.toCharArray();

        for(char x: znaki)
        {
            System.out.println(x);
        }

        System.out.println(liczby.length);

        Random randomizer = new Random();

        int[][] dwuwymiarowa = new int[20][5];

        for (int i = 0; i < dwuwymiarowa.length; i++) {
            for (int j = 0; j < dwuwymiarowa[0].length; j++) {
                dwuwymiarowa[i][j] = randomizer.nextInt(100);
                System.out.println(dwuwymiarowa[i][j]);
            }
        }

        ArrayList<String> owoce = new ArrayList<String>();
        owoce.add("kiwi");
        owoce.add("jabłko");
        owoce.add("banan");

        Collections.sort(owoce);


        for (String x : owoce) {
            System.out.println(x);
        }
    }

    public static void printArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    public static void randomizeArray(int[][] array, int minBound, int maxBound) {
        Random r = new Random();
        for (int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                array[i][j] = r.nextInt(maxBound-minBound)+minBound;
            }
        }
    }

    public static void randomizeArray(int[][] array) {
        Random r = new Random();
        for (int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                array[i][j] = r.nextInt();
            }
        }
    }

    public static void randomizeArray(int[] array, int minBound, int maxBound) {
        Random r = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = r.nextInt(maxBound-minBound)+minBound;
        }
    }

    public static void randomizeArray(int[] array) {
        Random r = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = r.nextInt();
        }
    }
}
