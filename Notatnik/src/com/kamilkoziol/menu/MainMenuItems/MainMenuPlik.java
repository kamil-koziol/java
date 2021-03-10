package com.kamilkoziol.menu.MainMenuItems;

import com.kamilkoziol.MainWindow;
import com.kamilkoziol.handlers.LastOpenedFilesHandler;
import com.kamilkoziol.utilities.ExtensionFilters;
import com.kamilkoziol.utilities.StringPrinter;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class MainMenuPlik extends JMenu {
    JMenu Ostatnie;
    MainWindow mainWindow;

    public MainMenuPlik(MainWindow mainWindow) {
        super();
        setText("Plik");
        this.mainWindow = mainWindow;

        JMenuItem Nowy = new JMenuItem("Nowy");
        Nowy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));

        JMenuItem Otworz = new JMenuItem("Otwórz");
        Otworz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));

        Ostatnie = new JMenu("Ostatnie");
        updateLastOpenedFiles();

        JMenuItem Zapisz = new JMenuItem("Zapisz");
        Zapisz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));

        JMenuItem ZapiszJako = new JMenuItem("Zapisz Jako");
        ZapiszJako.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, mainWindow.toolkit.getMenuShortcutKeyMaskEx()+InputEvent.SHIFT_DOWN_MASK));

        JMenuItem Drukuj = new JMenuItem("Drukuj");
        Drukuj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));

        Nowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.setFileFilter(ExtensionFilters.mainExtensionFilter);
                fileChooser.showDialog(null, "Utwórz");
                File selectedFile = fileChooser.getSelectedFile();

                if(selectedFile != null) {
                    try {
                        if(!selectedFile.createNewFile()) {
                            new FileWriter(selectedFile, false).close();
                        }

                        openAndLoadFile(selectedFile);

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        Otworz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.setFileFilter(ExtensionFilters.mainExtensionFilter);
                fileChooser.showOpenDialog(null);
                File selectedFile = fileChooser.getSelectedFile();

                if(selectedFile != null) {
                    openAndLoadFile(selectedFile);
                    updateLastOpenedFiles();
                }
            }
        });

        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainWindow.openedFile != null) {
                    try {
                        FileWriter fw = new FileWriter(mainWindow.openedFile, false);
                        fw.write(mainWindow.textArea.getText());
                        fw.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else {

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                    fileChooser.setFileFilter(ExtensionFilters.mainExtensionFilter);
                    fileChooser.showSaveDialog(null);
                    File selectedFile = fileChooser.getSelectedFile();

                    if(selectedFile != null) {
                        try {
                            FileWriter fw = new FileWriter(selectedFile, false);
                            fw.write(mainWindow.textArea.getText());
                            fw.close();
                            mainWindow.setOpenedFile(selectedFile);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        });

        ZapiszJako.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.setFileFilter(ExtensionFilters.mainExtensionFilter);
                fileChooser.showSaveDialog(null);
                File selectedFile = fileChooser.getSelectedFile();

                if(selectedFile != null) {
                    try {
                        FileWriter fw = new FileWriter(selectedFile, false);
                        fw.write(mainWindow.textArea.getText());
                        fw.close();
                        openAndLoadFile(selectedFile);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        Drukuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringPrinter.printString(mainWindow.textArea.getText(), mainWindow.textArea.getFont());
            }
        });

        this.add(Nowy);
        this.add(Otworz);
        this.add(Ostatnie);
        this.addSeparator();
        this.add(Zapisz);
        this.add(ZapiszJako);
        this.addSeparator();
        this.add(Drukuj);
    }

    void updateLastOpenedFiles() {
        this.remove(Ostatnie);
        Ostatnie = new JMenu("Ostatnie");

        for(File lastOpenedFile: LastOpenedFilesHandler.getLastOpenedFiles()) {
            if (lastOpenedFile.exists()) {

                JMenuItem menuItem = new JMenuItem(lastOpenedFile.getPath());
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String fileData = Files.readString(lastOpenedFile.toPath());
                            mainWindow.textArea.setText(fileData);
                            mainWindow.setOpenedFile(lastOpenedFile);
                            LastOpenedFilesHandler.addLastOpenedFile(lastOpenedFile);
                            updateLastOpenedFiles();
                        } catch (IOException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    }
                });
                Ostatnie.add(menuItem);
            }
        }

        this.insert(Ostatnie, 2);
    }
    void openAndLoadFile(File f) {
        try {
            String fileData = Files.readString(f.toPath());
            mainWindow.textArea.setText(fileData);
            mainWindow.setOpenedFile(f);
            LastOpenedFilesHandler.addLastOpenedFile(f);
            updateLastOpenedFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

