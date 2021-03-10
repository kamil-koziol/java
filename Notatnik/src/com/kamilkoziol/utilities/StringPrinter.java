package com.kamilkoziol.utilities;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class StringPrinter {
    public static void printString(String text, Font font) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();


        printerJob.setPrintable(new OutputPrinter(text, font));

        boolean printing = printerJob.printDialog();
        if(printing) {
            try {
                printerJob.print();
            } catch (PrinterException printerException) {
                printerException.printStackTrace();
            }
        }
    }
}

