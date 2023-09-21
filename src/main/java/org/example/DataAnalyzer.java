package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DataAnalyzer {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ScatterChart.class.getName());

    /**
     * Methot reads data line by line from initial file and calls other methods for calculations.
     * @param initialCubeFrame Initial data in array with min - max xyz coordinates.
     */
    public void manageData(int[] initialCubeFrame){

        CubeAnalyzer cube = new CubeAnalyzer();
        SphereAnalyzer sphere = new SphereAnalyzer();
        FileReaderWriter fileWriter = new FileReaderWriter();

        final String LAS_DATA = "C:\\Users\\ba_in\\Downloads\\2743_1234.json";
        File file;
        boolean firstLineSkipped = false;

        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        List<Double> zList = new ArrayList<>();
        double[] cubeFrameAndCoordinates = new double[10];
        int numberOfPoints = 0;

        try {
            file = new File(LAS_DATA);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                // All loops we start with initial cube
                cubeFrameAndCoordinates[3] = initialCubeFrame[3];
                cubeFrameAndCoordinates[4] = initialCubeFrame[4];
                cubeFrameAndCoordinates[5] = initialCubeFrame[5];
                cubeFrameAndCoordinates[6] = initialCubeFrame[6];
                cubeFrameAndCoordinates[7] = initialCubeFrame[7];
                cubeFrameAndCoordinates[8] = initialCubeFrame[8];

                String line = scanner.nextLine();

                // First line in .las file is metadata - we skip it.
                if (!firstLineSkipped) {
                    firstLineSkipped = true;
                    continue;
                }

                String[] values = line.split(",");

                // x, y, z coordinates are in the beginning of the line
                cubeFrameAndCoordinates[0] = Double.parseDouble(values[0]); // x
                cubeFrameAndCoordinates[1] = Double.parseDouble(values[1]); // y
                cubeFrameAndCoordinates[2] = Double.parseDouble(values[2]); // z

                // Finding the position of point in initial cube
                cubeFrameAndCoordinates = cube.findCube(cubeFrameAndCoordinates);

                if (sphere.pointIsInSphere(cubeFrameAndCoordinates)) {

                    // If point is in sphere, we are going to analyze "second level" cube
                    cubeFrameAndCoordinates = cube.findCube(cubeFrameAndCoordinates);

                    if (sphere.pointIsInSphere(cubeFrameAndCoordinates)){
                        xList.add(cubeFrameAndCoordinates[0]);
                        yList.add(cubeFrameAndCoordinates[1]);
                        zList.add(cubeFrameAndCoordinates[2]);
                        numberOfPoints++; // 7.618.421
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            LOGGER.info("An error occurred: " + e);
        }

        LOGGER.info("Counted number of valid points: " + numberOfPoints);

        fileWriter.write(xList, yList, zList);
    }

}
