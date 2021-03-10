package com.kamilkoziol;

import com.kamilkoziol.handlers.LastOpenedFilesHandler;
import com.kamilkoziol.menu.MainMenu;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public final class MainWindow extends JFrame {
    public JTextArea textArea;
    public File openedFile;
    public Toolkit toolkit = Toolkit.getDefaultToolkit();
    public UndoManager undoManager;
    public Clipboard clipboard = toolkit.getSystemClipboard();

    public MainWindow() {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notatnik");
        undoManager = new UndoManager();

        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        JScrollPane textAreaScroll = new JScrollPane(textArea);

        // ==== MENU ====
        MainMenu mainMenu = new MainMenu(this);
        setJMenuBar(mainMenu);

        add(textAreaScroll);

        openLastOpenedFile();
        setVisible(true);
    }

    void openLastOpenedFile() {
        ArrayList<File> lastOpenedFiles = LastOpenedFilesHandler.getLastOpenedFiles();
        if (lastOpenedFiles.size() >= 1) {
            File lastOpenedFile = lastOpenedFiles.get(0);
            String fileData = null;
            try {
                fileData = Files.readString(lastOpenedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            textArea.setText(fileData);
            MainWindow.this.setOpenedFile(lastOpenedFile);
        }
    }

    public void setOpenedFile(File f) {
        openedFile = f;
        MainWindow.this.setTitle("Notatnik - " + f.getName());
    }
}
