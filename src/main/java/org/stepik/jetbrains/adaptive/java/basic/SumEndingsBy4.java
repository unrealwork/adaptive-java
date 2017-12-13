package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumEndingsBy4 {

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    final int sum = reader.lines()
        .mapToInt(Integer::parseInt).filter(n -> n % 10 == 4).sum();
    System.out.println(sum);
  }
}
