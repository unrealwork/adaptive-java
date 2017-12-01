package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SizeOfParts {

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      int ready = 0;
      int fixed = 0;
      int broken = 0;

      int size = Integer.parseInt(reader.readLine());

      for (int i = 0; i < size; i++) {
        int res = Integer.parseInt(reader.readLine());
        if (res == 0) {
          ready++;
        } else if (res == 1) {
          fixed++;
        } else if (res == -1) {
          broken++;
        } else {
          throw new IllegalStateException();
        }
      }
      System.out.println(String.format("%d %d %d", ready, fixed, broken));
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
