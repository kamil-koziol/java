package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Panel extends JFrame implements ActionListener {
    JButton button;
    JButton button2;
    JButton button3;

    JTextField textField;
    JTextArea textArea;
    int[][] tablica;

    public Panel() {
        setVisible(true);
        setSize(1000, 1000);

        Container c = getContentPane();
        c.setBackground(Color.blue);
        c.setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Losuj");
        button2 = new JButton("Sortuj");
        button3 = new JButton("Klik");
        textArea = new JTextArea(25, 75);
        textField = new JTextField(20);

        tablica = new int[20][20];
        randomizeArray(tablica);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeArray(tablica);
                displayArray(textArea, tablica);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortArray(tablica);
                displayArray(textArea, tablica);
            }
        });

        c.add(button);
        c.add(button2);
        c.add(button3);

        c.add(textArea);

        c.add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Działa");
    }

    public void randomizeArray(int[][] arr) {
        Random r = new Random();

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = r.nextInt(100);
            }
        }
    }

    public void displayArray(JTextArea ta, int[][] arr) {
        ta.setText("");

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                ta.append(Integer.toString(arr[i][j]) + " ");
            }

            ta.append("\n");
        }
    }

    public int[] flattenArray(int[][] arr) {
        int[] flattenedArr = new int[arr.length*arr[0].length];

        int counter = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                flattenedArr[counter] = arr[i][j];
                counter++;
            }
        }

        return flattenedArr;
    }
    public void sortArray(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[] flattenedArray = flattenArray(arr);
        Arrays.sort(flattenedArray);


        int counter = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
//                System.out.println((i*j)+j);
                arr[i][j] = flattenedArray[counter];
                counter ++;
            }
        }
    }


}
