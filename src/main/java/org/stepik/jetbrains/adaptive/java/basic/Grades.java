package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grades {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    int[] grades = new int[4];
    int size = Integer.parseInt(reader.readLine());
    for (int i = 0; i < size; i++) {
      int grade = Integer.parseInt(reader.readLine());
      grades[grade - 2]++;
    }
    for (Integer count : grades) {
      System.out.printf("%d ", count);
    }
  }
}
