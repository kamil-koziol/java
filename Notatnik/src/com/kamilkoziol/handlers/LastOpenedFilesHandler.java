package com.kamilkoziol.handlers;

import com.kamilkoziol.utilities.ProjectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LastOpenedFilesHandler {
    public static void addLastOpenedFile(File f) {
        try {
            FileWriter fileWriter = new FileWriter(ProjectFiles.lastOpenedFiles, true);
            fileWriter.write(f.getPath() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<File> getLastOpenedFiles() {
        ArrayList<File> lastOpenedFiles = new ArrayList<File>();
        try {
            Scanner rowScanner = new Scanner(ProjectFiles.lastOpenedFiles);
            while(rowScanner.hasNext()) {
                File lastOpenedFile = new File(rowScanner.next());
                lastOpenedFiles.add(lastOpenedFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final int LAST_OPENED_FILE_SIZE = 5;

        ArrayList<File> files = new ArrayList<File>();
        Collections.reverse(lastOpenedFiles);
        for (File lastOpenedFile: lastOpenedFiles) {
            if(files.size() == LAST_OPENED_FILE_SIZE) {
                break;
            }
            if(!files.contains(lastOpenedFile)) {
                files.add(lastOpenedFile);
            }
        }

        if(files.size() > LAST_OPENED_FILE_SIZE) {
            return new ArrayList<File>(files.subList(0,LAST_OPENED_FILE_SIZE));
        } else {
            return files;
        }
    }
}
