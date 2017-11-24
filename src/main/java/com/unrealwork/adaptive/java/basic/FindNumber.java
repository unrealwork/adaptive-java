package com.unrealwork.adaptive.java.basic;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FindNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(solve(in.nextInt()));
    in.close();
  }

  private static int sumOfDigit(int n) {
    return Integer.toString(n)
        .chars()
        .map(c -> c - '0')
        .sum();
  }

  private static long solve(final int n) {
    final int goal = sumOfDigit(n);
    return IntStream.range(1, n)
        .filter(num -> goal == sumOfDigit(num))
        .count();
  }
}
