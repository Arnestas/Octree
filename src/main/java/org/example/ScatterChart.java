package org.example;

import ChartDirector.Chart;
import ChartDirector.ThreeDScatterChart;
import java.util.List;
import java.util.logging.Logger;

public class ScatterChart {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ScatterChart.class.getName());

    /**
     * Method generates a scatter chart from x, y, z coordinates.
     * Code from ChartDirector 7.0
     * @param xList x coordinates.
     * @param yList y coordiantes.
     * @param zList z coordinates.
     */

    public void generateScatterChart(List<Double> xList, List<Double> yList, List<Double> zList){

        // I am using a smaller range of points, because program brakes because of out of memory
        int size = (int) (xList.size() / 3.5);
        double[] xData = new double[size];
        double[] yData = new double[size];
        double[] zData = new double[size];

        LOGGER.info("Started to convert the List to an Array");
        for (int i = 0; i < size; i++){
            xData[i] = xList.get(i);
            yData[i] = yList.get(i);
            zData[i] = zList.get(i);
        }

        LOGGER.info("Started to generate a diagram");

// Create a ThreeDScatterChart object of size 720 x 600 pixels
        ThreeDScatterChart c = new ThreeDScatterChart(1000, 1000);

// Add a title to the chart using 20 points Times New Roman Italic font
        c.addTitle("3D Scatter Chart (1)  ", "Times New Roman Italic", 20);

// Set the center of the plot region at (350, 280), and set width x depth x height to 360 x 360 x
// 270 pixels
        c.setPlotRegion(400, 400, 400, 500, 500);
//        c.setPlotRegion(350, 280, 360, 360, 270);

// Add a scatter group to the chart using 11 pixels glass sphere symbols, in which the color depends
// on the z value of the symbol

        c.addScatterGroup(xData, yData, zData,"", Chart.GlassSphere2Shape, 11, Chart.SameAsMainColor);

// Add a color axis (the legend) in which the left center is anchored at (645, 270). Set the length
// to 200 pixels and the labels on the right side.
        c.setColorAxis(645, 270, Chart.Left, 200, Chart.Right);

// Set the x, y and z axis titles using 10 points Arial Bold font
        c.xAxis().setTitle("X-Axis Place Holder", "Arial Bold", 10);
        c.yAxis().setTitle("Y-Axis Place Holder", "Arial Bold", 10);
        c.zAxis().setTitle("Z-Axis Place Holder", "Arial Bold", 10);

        c.makeChart("output/scatterChart.png");

        LOGGER.info("Chart created and saved as 'barchart.png'.");
    }

}
