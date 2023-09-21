package org.example;

public class SphereAnalyzer {
    public boolean pointIsInSphere(double [] cubeAndCoordinates){
        double x = cubeAndCoordinates[0];
        double y = cubeAndCoordinates[1];
        double z = cubeAndCoordinates[2];

        double minX = cubeAndCoordinates[3];
        double minY = cubeAndCoordinates[4];
        double minZ = cubeAndCoordinates[5];
        double maxX = cubeAndCoordinates[6];
        double maxY = cubeAndCoordinates[7];
        double maxZ = cubeAndCoordinates[8];
        double r = cubeAndCoordinates[9];

        double centerX = (maxX+minX)/2;
        double centerY = (maxY+minY)/2;
        double centerZ = (maxZ+minZ)/2;

        // (x−x0)2+(y−y0)2+(z−z0)2=r2
        return pow(x, centerX) + pow(y, centerY) + pow(z,centerZ) <= pow(r, 0);
    }

    public double pow(double x, double x0){
        return Math.pow(x - x0, 2);
    }

}
