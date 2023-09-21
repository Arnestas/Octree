package org.example;

public class CubeAnalyzer {

    /**
     * Method is looking the 1/8 position of point in the cube
     * @param cubeFrameAndCoordinates An array of xyz coordinates and cube "frame"
     * @return same coordinates of the point and initial cube
     */
    public double[] findCube(double[] cubeFrameAndCoordinates){
        double x = cubeFrameAndCoordinates[0];
        double y = cubeFrameAndCoordinates[1];
        double z = cubeFrameAndCoordinates[2];

        double minX = cubeFrameAndCoordinates[3];
        double minY = cubeFrameAndCoordinates[4];
        double minZ = cubeFrameAndCoordinates[5];
        double maxX = cubeFrameAndCoordinates[6];
        double maxY = cubeFrameAndCoordinates[7];
        double maxZ = cubeFrameAndCoordinates[8];

        double centerX = (maxX+minX)/2;
        double centerY = (maxY+minY)/2;
        double centerZ = (maxZ+minZ)/2;
        double r = (maxX-minX)/4;

        cubeFrameAndCoordinates[9] = r;

        if (x < centerX) {
            if (y < centerY) {
                if (z < centerZ) {
//                    System.out.println("x max = centerX, y max = centerY, z max = centerZ, cube 7 " + x + " < " + centerX + " "+ y +" < " + centerY + " " + z + " < " + centerZ);
//                    cubeFrameAndCoordinates[3] = minX;
//                    cubeFrameAndCoordinates[4] = minY;
//                    cubeFrameAndCoordinates[5] = minZ;
                    cubeFrameAndCoordinates[6] = centerX;
                    cubeFrameAndCoordinates[7] = centerY;
                    cubeFrameAndCoordinates[8] = centerZ;
                } else {
//                    System.out.println("x max = centerX, y max = centerY, z max = maxZ, cube 5 " + x + " < " + centerX + " "+ y +" < " + centerY + " " + z + " > " + centerZ);
//                    cubeFrameAndCoordinates[3] = minX;
//                    cubeFrameAndCoordinates[4] = minY;
                    cubeFrameAndCoordinates[5] = centerZ;
                    cubeFrameAndCoordinates[6] = centerX;
                    cubeFrameAndCoordinates[7] = centerY;
//                    cubeFrameAndCoordinates[8] = maxZ;
                }
            } else if (y > centerY){
                if (z < centerZ) {

//                    logger.info("x max = centerX, y max = maxY, z max = centerZ, cube 3 " + x + " < " + centerX + " "+ y +" > " + centerY + " " + z + " < " + centerZ);
//                    cubeFrameAndCoordinates[3] = minX;
                    cubeFrameAndCoordinates[4] = centerY;
//                    cubeFrameAndCoordinates[5] = minZ;
                    cubeFrameAndCoordinates[6] = centerX;
//                    cubeFrameAndCoordinates[7] = maxY;
                    cubeFrameAndCoordinates[8] = centerZ;
                } else {
//                    System.out.println("x max = centerX, y max = maxY, z max = mazZ, cube 1 " + x + " < " + centerX + " "+ y +" > " + centerY + " " + z + " > " + centerZ);
//                    cubeFrameAndCoordinates[3] = minX;
                    cubeFrameAndCoordinates[4] = centerY;
                    cubeFrameAndCoordinates[5] = centerZ;
                    cubeFrameAndCoordinates[6] = centerX;
//                    cubeFrameAndCoordinates[7] = maxY;
//                    cubeFrameAndCoordinates[8] = maxZ;
                }
            }
        } else if (x > centerX) {
            if (y < centerY){
                if (z < centerZ){
//                    System.out.println("x max = maxX, y max = centerY, z max = centerZ, cube 8 " + x + " > " + centerX + " "+ y +" < " + centerY + " " + z + " < " + centerZ);
                    cubeFrameAndCoordinates[3] = centerX;
//                    cubeFrameAndCoordinates[4] = minY;
//                    cubeFrameAndCoordinates[5] = minZ;
//                    cubeFrameAndCoordinates[6] = maxX;
                    cubeFrameAndCoordinates[7] = centerY;
                    cubeFrameAndCoordinates[8] = centerZ;
                } else {
//                    System.out.println("x max = maxX, y max = centerY, z max = maxZ, cube 6 " + x + " > " + centerX + " "+ y +" < " + centerY + " " + z + " > " + centerZ);
                    cubeFrameAndCoordinates[3] = centerX;
//                    cubeFrameAndCoordinates[4] = minY;
                    cubeFrameAndCoordinates[5] = centerZ;
//                    cubeFrameAndCoordinates[6] = maxX;
                    cubeFrameAndCoordinates[7] = centerY;
//                    cubeFrameAndCoordinates[8] = maxZ;
                }
            } else if (y > centerY){
                if (z < centerZ){
//                    ("x max = maxX, y max = maxY, z max = centerZ, cube 4 " + x + " > " + centerX + " "+ y +" > " + centerY + " " + z + " < " + centerZ);
                    cubeFrameAndCoordinates[3] = centerX;
                    cubeFrameAndCoordinates[4] = centerY;
//                    cubeFrameAndCoordinates[5] = minZ;
//                    cubeFrameAndCoordinates[6] = maxX;
//                    cubeFrameAndCoordinates[7] = maxY;
                    cubeFrameAndCoordinates[8] = centerZ;
                } else {
//                    System.out.println("x max = maxX, y max = maxY, z max = maxZ, cube 2 " + x + " > " + centerX + " "+ y +" > " + centerY + " " + z + " > " + centerZ);
                    cubeFrameAndCoordinates[3] = centerX;
                    cubeFrameAndCoordinates[4] = centerY;
                    cubeFrameAndCoordinates[5] = centerZ;
//                    cubeFrameAndCoordinates[6] = maxX;
//                    cubeFrameAndCoordinates[7] = maxY;
//                    cubeFrameAndCoordinates[8] = maxZ;
                }
            }
        }
        return cubeFrameAndCoordinates;
    }
}
