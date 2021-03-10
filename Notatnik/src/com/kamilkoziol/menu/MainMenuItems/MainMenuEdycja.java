package com.kamilkoziol.menu.MainMenuItems;

import com.kamilkoziol.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainMenuEdycja extends JMenu {
    MainWindow mainWindow;

    public MainMenuEdycja(MainWindow mainWindow) {
        super();

        this.mainWindow = mainWindow;

        setText("Edycja");
        JMenuItem Kopiuj = new JMenuItem("Kopiuj");
        Kopiuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Kopiuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = mainWindow.textArea.getSelectedText();
                mainWindow.toolkit.getSystemClipboard().setContents(new StringSelection(selectedText), null);
            }
        });

        JMenuItem Wklej = new JMenuItem("Wklej");
        Wklej.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Wklej.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clipboard clipboard = mainWindow.toolkit.getSystemClipboard();
                try {
                    mainWindow.textArea.append(clipboard.getData(DataFlavor.stringFlavor).toString());
                    System.out.println(mainWindow.textArea.getInputContext());
                } catch (UnsupportedFlavorException | IOException unsupportedFlavorException) {
                    unsupportedFlavorException.printStackTrace();
                }
            }
        });
        JMenuItem Wytnij = new JMenuItem("Wytnij");
        Wytnij.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Wytnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = mainWindow.textArea.getSelectedText();
                mainWindow.toolkit.getSystemClipboard().setContents(new StringSelection(selectedText), null);
                mainWindow.textArea.replaceRange("",mainWindow.textArea.getSelectionStart(), mainWindow.textArea.getSelectionEnd());
            }
        });

        JMenuItem Cofnij = new JMenuItem("Cofnij");
        Cofnij.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainWindow.undoManager.canUndo()) {
                    mainWindow.undoManager.undo();
                }
            }
        });
        JMenuItem Wstecz = new JMenuItem("Wstecz");
        Wstecz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Wstecz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainWindow.undoManager.canRedo()) {
                    mainWindow.undoManager.redo();
                }
            }
        });


        add(Kopiuj);
        add(Wklej);
        add(Wytnij);

        addSeparator();

        add(Cofnij);
        add(Wstecz);
    }
}
