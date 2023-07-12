/*
 * Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
**Input:** mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]

**Output:**

[[7,0,0],[-7,0,3]]
 * 
 */

package in.ineuron.gouthami;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    public static int[][] multiplySparseMatrices(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < k; x++) {
                    result[i][j] += mat1[i][x] * mat2[x][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] result = multiplySparseMatrices(mat1, mat2);

        // Printing the resulting matrix
        for (int i = 0; i < result.length; i++) {
            System.out.println("SparseMatrix is :: " +Arrays.toString(result[i]));
        }
    }
}
