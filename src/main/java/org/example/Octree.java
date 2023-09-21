package org.example;

import java.util.List;
import java.util.logging.Logger;

/**
 * The program uses Octree algorithm and embeds a sphere in each of the Octree cubes.
 * All the points within a sphere are subdivided into eight cubes (with spheres inside).
 * All the points that are outside of the sphere are discarded.
 * The result (valid points) are visualised.
 */

public class Octree {
    public static void main(String[] args){
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        FileReaderWriter fileReader = new FileReaderWriter();
        ScatterChart scatterChart = new ScatterChart();

        // Initial cube (frame)
        final int minX = 2743000;   // 1000  center = 2743500
        final int minY = 1234000;   // 1000 center = 1234500
        final int minZ = 1800;      // 660
        final int maxX = 2744000;
        final int maxY = 1235000;
        final int maxZ = 2460 + 340;

        int[] cubeFrameAndCoordinates = new int[10];

        cubeFrameAndCoordinates[3] = minX;
        cubeFrameAndCoordinates[4] = minY;
        cubeFrameAndCoordinates[5] = minZ;
        cubeFrameAndCoordinates[6] = maxX;
        cubeFrameAndCoordinates[7] = maxY;
        cubeFrameAndCoordinates[8] = maxZ;

        dataAnalyzer.manageData(cubeFrameAndCoordinates);

        List<List<Double>> listOfXYZLists = fileReader.read();

        scatterChart.generateScatterChart(listOfXYZLists.get(0), listOfXYZLists.get(1), listOfXYZLists.get(2));

        Logger.getLogger("finish").info("The program has finished work.");
    }

}