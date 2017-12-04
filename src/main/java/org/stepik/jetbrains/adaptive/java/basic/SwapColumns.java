package org.stepik.jetbrains.adaptive.java.basic;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.Scanner;

/**
 * Given a two-dimensional array (matrix) and the two numbers: i and j. Swap the columns with
 * indices i and j within the matrix.
 *
 * <p>Input contains matrix dimensions n and m, not exceeding 100,
 * then the elements of the matrix, then the indices i and j.</p>
 */
public class SwapColumns {

  /**
   * Main app point.
   *
   * @param args - empty args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in, UTF_8.name());
    int rowsCount = in.nextInt();
    int columnsCount = in.nextInt();
    int[][] matrix = new int[rowsCount][columnsCount];
    for (int i = 0; i < rowsCount; i++) {
      for (int j = 0; j < columnsCount; j++) {
        matrix[i][j] = in.nextInt();
      }
    }
    int firstColumnIndex = in.nextInt();
    int secondColumnIndex = in.nextInt();
    swapColumns(matrix, firstColumnIndex, secondColumnIndex);
    printMatrix(matrix, rowsCount, columnsCount);
  }

  private static void swapColumns(int[][] matrix, int firstColumnIndex,
      int secondColumnIndex) {
    int rowsCount = matrix.length;
    for (int i = 0; i < rowsCount; i++) {
      int tmp = matrix[i][firstColumnIndex];
      matrix[i][firstColumnIndex] = matrix[i][secondColumnIndex];
      matrix[i][secondColumnIndex] = tmp;
    }
  }


  private static void printMatrix(int[][] matrix, int m, int n) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
