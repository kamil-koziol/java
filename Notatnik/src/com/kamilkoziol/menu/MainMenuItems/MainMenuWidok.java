package com.kamilkoziol.menu.MainMenuItems;

import com.kamilkoziol.MainWindow;
import com.kamilkoziol.utilities.ProjectFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class MainMenuWidok extends JMenu {
    int fontSize = 24;
    int fontStyle = Font.PLAIN;
    String fontFamily = "Helvetica";
    Properties fontProperties;
    boolean darkTheme = false;
    boolean lineWrap = false;

    MainWindow mainWindow;

    public MainMenuWidok(MainWindow mainWindow) {
        super();

        this.mainWindow = mainWindow;

        loadConfigProperties();
        setConfigProperties();
        updateTextAreaFont();

        JMenuItem Zwieksz = new JMenuItem("Zwiększ");
        Zwieksz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Zwieksz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize++;
                updateTextAreaFont();
                updateConfigFile();
            }
        });

        JMenuItem Pomniejsz = new JMenuItem("Pomniejsz");
        Pomniejsz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        Pomniejsz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fontSize >= 1) {
                    fontSize--;
                    updateTextAreaFont();
                    updateConfigFile();
                }
            }
        });

        JMenuItem StylCzcionki = new JMenu("Styl Czcionki");

        JMenuItem StylCzcionkiNormalny = new JMenuItem("Normalny");
        StylCzcionkiNormalny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontStyle = Font.PLAIN;
                updateTextAreaFont();
                updateConfigFile();
            }
        });
        StylCzcionki.add(StylCzcionkiNormalny);

        JMenuItem StylCzcionkiPogrubiony = new JMenuItem("Pogrubiony");
        StylCzcionkiPogrubiony.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        StylCzcionkiPogrubiony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fontStyle == Font.BOLD) {
                    fontStyle = Font.PLAIN;
                } else {
                    fontStyle = Font.BOLD;
                }
                updateTextAreaFont();
                updateConfigFile();
            }
        });
        StylCzcionki.add(StylCzcionkiPogrubiony);

        JMenuItem StylCzcionkiPrzechylony = new JMenuItem("Przechylony");
        StylCzcionkiPrzechylony.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, mainWindow.toolkit.getMenuShortcutKeyMaskEx()));
        StylCzcionkiPrzechylony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fontStyle == Font.ITALIC) {
                    fontStyle = Font.PLAIN;
                } else {
                    fontStyle = Font.ITALIC;
                }
                updateTextAreaFont();
                updateConfigFile();
            }
        });
        StylCzcionki.add(StylCzcionkiPrzechylony);

        JMenu Czcionka = new JMenu("Czcionka");
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        char[] alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for(char chr: alfabet) {
            JMenu menu = new JMenu(String.valueOf(chr));
            for(String font: fonts) {
                if(font.toUpperCase().startsWith(String.valueOf(chr))) {
                    JMenuItem menuFont = new JMenuItem(font);

                    menuFont.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            fontFamily = font;
                            updateTextAreaFont();
                            updateConfigFile();
                        }
                    });
                    menuFont.setFont(new Font(font, Font.PLAIN, 12));
                    menu.add(menuFont);
                }
            }

            Czcionka.add(menu);
        }

        JCheckBox CiemnyMotyw = new JCheckBox("Ciemny motyw", darkTheme);
        CiemnyMotyw.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                darkTheme = !darkTheme;
                setTheme();
                updateConfigFile();
            }
        });

        JCheckBox ZawijanieWierszy = new JCheckBox("Zawijanie Wierszy", lineWrap);
        ZawijanieWierszy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lineWrap = !lineWrap;
                mainWindow.textArea.setLineWrap(lineWrap);
                updateConfigFile();
            }
        });
        mainWindow.textArea.setLineWrap(lineWrap);

        add(Zwieksz);
        add(Pomniejsz);
        add(StylCzcionki);
        add(Czcionka);
        add(CiemnyMotyw);
        add(ZawijanieWierszy);


        setText("Widok");

    }

    void updateTextAreaFont() {
        mainWindow.textArea.setFont(new Font(fontFamily, fontStyle, fontSize));
    }

    void updateConfigFile() {
        fontProperties.setProperty("fontSize", Integer.toString(fontSize));
        fontProperties.setProperty("fontFamily", fontFamily);
        fontProperties.setProperty("fontStyle", Integer.toString(fontStyle));
        fontProperties.setProperty("darkTheme", darkTheme? "1":"0");
        fontProperties.setProperty("lineWrap", lineWrap? "1":"0");
        try {
            FileWriter fontPropertiesWriter = new FileWriter(ProjectFiles.configFile);
            fontProperties.store(fontPropertiesWriter, "Font Updates");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    void loadConfigProperties() {
        try {
            FileReader reader = new FileReader(ProjectFiles.configFile);
            fontProperties = new Properties();
            fontProperties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setConfigProperties() {
        fontSize = Integer.parseInt(fontProperties.get("fontSize").toString());
        fontStyle = Integer.parseInt(fontProperties.get("fontStyle").toString());
        fontFamily = fontProperties.get("fontFamily").toString();
        darkTheme = fontProperties.get("darkTheme").toString().equals("1");
        lineWrap = fontProperties.get("lineWrap").toString().equals("1");
        setTheme();
    }

    void setTheme() {
        if(darkTheme) {
            mainWindow.textArea.setBackground(new Color(40, 44, 52));
            mainWindow.textArea.setForeground(Color.WHITE);
            mainWindow.textArea.setCaretColor(Color.WHITE);
        } else {
            mainWindow.textArea.setBackground(Color.WHITE);
            mainWindow.textArea.setForeground(Color.BLACK);
            mainWindow.textArea.setCaretColor(Color.BLACK);
        }
    }
}
