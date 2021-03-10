package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WorkingWithFiles {
    public static void main() throws IOException {
        File file = new File("filename.txt");
        if(file.createNewFile()) {
            System.out.println("Utworzono plik");
        }

        PrintWriter writer2 = new PrintWriter(file);
        writer2.write("Hejka");
        writer2.flush();
        writer2.close();

        Random r = new Random();
        RandomAccessFile zapis = new RandomAccessFile(file, "rw");
        zapis.seek(zapis.length());
        for(int i=0; i<1000; i++) {
            zapis.writeUTF("Losowa: " + (10 + r.nextInt(5)));
        }

        zapis.close();

        File file2 = new File("filename2.txt");
        if(file2.createNewFile()) {
            System.out.println("Utworzono plik");
        }

        FileWriter fw = new FileWriter(file2, true);
        PrintWriter pw = new PrintWriter(fw, true);
        for(int i=0; i<60; i++) {
            pw.write(r.nextInt(30) + "\n");
        }

        int[][] myArray = new int[12][12];
        WorkingWithArrays.randomizeArray(myArray);
        WorkingWithArrays.printArray(myArray);

        pw.close();

        int suma = 0;
        Scanner myReader = new Scanner(file2);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            suma += Integer.parseInt(data);
        }

        System.out.println(suma);

        myReader.close();

        // Do zadania domowego

//        int[] tablica = new int[100];
//        WorkingWithArrays.randomizeArray(tablica);
//        File plik = new File("1d.txt");
//        saveArray(tablica, plik);
//        WorkingWithArrays.printArray(tablica);

        int[][] tab = new int[12][5];
        WorkingWithArrays.randomizeArray(tab, 0, 20);
        File newfile = new File("tablica.txt");
        saveArray(tab, newfile);
        WorkingWithArrays.printArray(read2DArray(newfile));

    }

    public static void saveArray(int[] array, File file) throws IOException {
        file.createNewFile();

        FileWriter fw = new FileWriter(file, true);

        for(int i=0; i<array.length-1; i++) {
            fw.write(array[i] + ",");
        }

        fw.write(array[array.length-1] + "\n");

        fw.close();
    }

    public static void saveArray(int[][] array, File file) throws IOException {
        for(int i=0; i<array.length; i++) {
            saveArray(array[i], file);
        }
    }

    public static int[] readArray(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] nums = line.split(",");

        int[] array = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }

        scanner.close();

        return array;
    }

    public static int[][] read2DArray(File file) throws FileNotFoundException {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();

        int maxRowLength = 0;

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] nums = line.split(",");

            int[] row = new int[nums.length];
            for (int i=0; i<nums.length; i++) {
                row[i] = Integer.parseInt(nums[i]);
            }

            if(row.length > maxRowLength) {
                maxRowLength = row.length;
            }

            arrayList.add(row);
        }
        scanner.close();

        int[][] array = new int[arrayList.size()][maxRowLength];

        int i=0;
        for (int[] arr: arrayList) {
            array[i] = arr;
            i++;
        }

        return array;
    }
}
