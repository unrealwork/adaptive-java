package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceLength {

  private static final char ZERO = '0';

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    int count = 0;
    while (reader.readLine().charAt(0) != ZERO) {
      count++;
    }
    System.out.println(count);
    reader.close();
  }
}
