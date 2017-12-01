package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix2 {

  private static final char SPACE = ' ';
  public static final String LINE_SEPARATOR = System.lineSeparator();

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
      final int gridSize = Integer.parseInt(reader.readLine());
      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
          sb.append(Math.abs(i - j));
          sb.append(SPACE);
        }
        sb.append(LINE_SEPARATOR);
      }
      System.out.println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
