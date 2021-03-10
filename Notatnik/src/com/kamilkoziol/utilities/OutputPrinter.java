package com.kamilkoziol.utilities;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class OutputPrinter implements Printable {
    private String printData;
    private Font font;
    public OutputPrinter(String printDataIn, Font font) {
        this.printData = printDataIn;
        this.font = font;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        int x = (int) pf.getImageableX();
        int y = (int) pf.getImageableY();
        g2d.translate(x, y);

        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        BufferedReader br = new BufferedReader(new StringReader(printData));

        try {
            String line;
            x += 50;
            y += 50;
            while ((line = br.readLine()) != null) {
                y += lineHeight;
                g2d.drawString(line, x, y);
            }
        } catch (IOException e) {
            //
        }

        return PAGE_EXISTS;
    }
}
