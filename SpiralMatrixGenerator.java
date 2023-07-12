/*
 * 💡 **Question 7**

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
**Input:** n = 3

**Output:** [[1,2,3],[8,9,4],[7,6,5]]
 * 
 */
package in.ineuron.gouthami;


import java.util.Arrays;

public class SpiralMatrixGenerator {
    public static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Fill top row
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;

            // Fill right column
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            // Fill bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = num++;
                }
                rowEnd--;
            }

            // Fill left column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
                colStart++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] spiralMatrix = generateSpiralMatrix(n);

        // Printing the generated spiral matrix
        for (int i = 0; i < n; i++) {
            System.out.println("SpiralMatrix is :: " +Arrays.toString(spiralMatrix[i]));
        }
    }
}

