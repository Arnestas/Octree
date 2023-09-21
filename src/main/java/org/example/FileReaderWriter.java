package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileReaderWriter {
    final static String RESULTS = "output/results.txt";

    /**
     * Method writes valid coordinates to the file
     * @param xList x coordinales
     * @param yList y coordinales
     * @param zList z coordinales
     */
    public void write(List<Double> xList, List<Double> yList, List<Double> zList) {
        FileWriter fileWriter;
        String stringToWrite;

        try {
            fileWriter = new FileWriter(RESULTS);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            int listSize = xList.size();
            for (int i = 0; i < listSize; i++){
                stringToWrite = xList.get(i) + ", " + yList.get(i) + ", " + zList.get(i);
                printWriter.println(stringToWrite);
            }
            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.getLogger("writeToFile").info("Results were written to " + RESULTS);
    }

    /**
     * Method reads coordinates from file.
     */
    public List<List<Double>> read(){

        List<List<Double>> listOfLists = new ArrayList<>();
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        List<Double> zList = new ArrayList<>();

        try {
            Logger.getLogger("readFromFile").info("Reading from file " + RESULTS);
        File file = new File(RESULTS);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");

            xList.add(Double.parseDouble(values[0]));
            yList.add(Double.parseDouble(values[1]));
            zList.add(Double.parseDouble(values[2]));
        }
        scanner.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger("readingError").info("An error occurred: " + e);
        }

        listOfLists.add(xList);
        listOfLists.add(yList);
        listOfLists.add(zList);

        return listOfLists;
    }

}