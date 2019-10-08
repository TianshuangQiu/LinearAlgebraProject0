package linearsystems;

import java.util.*;

/**
 *
 * @author eqiu
 */
public class LinearSystems {

    static ArrayList<ArrayList<Double>> storageMatrix = new ArrayList<>();
    static double[][] solveMatrix;

    /**
     * @param args the command line arguments
     */
    static double[] gaussianElimintate(double[] firstRow, double[] secondRow, int index) throws Exception {
        if (firstRow.length != secondRow.length)
            throw new Exception("INPUT MATRIX IS NOT THE SAME SIZE");
        if (2 * index > (firstRow.length + secondRow.length))
            throw new Exception("LOOKING FOR VARIABLE THAT IS OUTSIDE OF RANGE");
        if (firstRow[index] * secondRow[index] != 0) {
            double multiplier = firstRow[index] / secondRow[index];
            double[] buffer = new double[firstRow.length];
            int indexCounter = 0;
            for (double d : secondRow) {
                buffer[indexCounter] = Math.round((d * multiplier - firstRow[indexCounter]) * 1000000) / 1000000;
                indexCounter++;
            }

            return buffer;
        } else
            return secondRow;
    }

    static void printMatrix() {
        //System.out.println(Arrays.deepToString(solveMatrix));
        System.out.println();
        for (int i = 0; i < solveMatrix.length; i++)
            System.out.println(Arrays.toString(solveMatrix[i]));
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        solveMatrix = new double[3][4];
        int rowNum = solveMatrix.length;
        int columnNum = solveMatrix[0].length;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                solveMatrix[i][j] = (int) (100 * Math.random());
        printMatrix();
        int rowCounter = 0;
        for (int i = 0; i < columnNum; i++) { //choosing a variable to begin elimination

            for (int j = rowCounter + 1; j < rowNum; j++) {
                solveMatrix[j] = gaussianElimintate(solveMatrix[rowCounter], solveMatrix[j], i);
                printMatrix();
            }
            rowCounter++;
        }

    }

}
