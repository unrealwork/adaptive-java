package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

/**
 * Given array rectangle array n×m in size. Rotate it by 90 degrees clockwise,
 * by recording the result into the new array m×n in size.
 */
public class RotateRectangleArray {
  public static class Matrix {
    private int[][] array;
    private int width;
    private int height;

    Matrix(int m, int n) {
      this.width = n;
      this.height = m;
      this.array = new int[m][n];
    }

    private void setElement(int i, int j, int value) {
      array[i][j] = value;
    }

    public int getElement(int i, int j) {
      return array[i][j];
    }


    Matrix rotateRight() {
      Matrix matrix = new Matrix(width, height);
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          matrix.setElement(j, height - 1 - i, array[i][j]);
        }
      }
      return matrix;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          builder.append(String.format("%s ", array[i][j]));
        }
        builder.append(System.lineSeparator());
      }
      return builder.toString();
    }

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }
  }

  /**
   * Main method.
   * @param args without
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    Matrix matrix = new Matrix(m, n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix.setElement(i, j, in.nextInt());
      }
    }
    System.out.println(matrix.rotateRight());
  }
}
