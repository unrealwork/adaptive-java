package com.unrealwork.adaptive.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArithmeticProgression {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();

    Integer[] a = Arrays.stream(in.nextLine().split(" "))
        .map(Integer::parseInt)
        .sorted()
        .toArray(Integer[]::new);

    System.out.println(solve(a) ? "Yes" : "No");
    in.close();
  }

  private static boolean solve(Integer[] array) {
    if (array.length < 2) {
      return true;
    }

    final int step = array[1] - array[0];

    for (int i = 2; i < array.length; i++) {
      if (step != (array[i] - array[i - 1])) {
        return false;
      }
    }

    return true;
  }
}
