package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxEndingsBy4 {

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    final int max = reader.lines().skip(1)
        .mapToInt(Integer::parseInt).filter(n -> n % 4 == 0).max().getAsInt();
    System.out.println(max);
  }
}
