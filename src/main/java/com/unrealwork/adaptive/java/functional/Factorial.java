package com.unrealwork.adaptive.java.functional;

import java.util.stream.LongStream;

public class Factorial {

  /**
   * Calculates the factorial of the given number n
   *
   * @param n >= 0
   * @return factorial value
   */
  public static long factorial(long n) {
    return LongStream.range(1, n + 1)
        .reduce(1, (left, right) -> left * right);
  }

  public static void main(String[] args) {
    System.out.println(factorial(0));
  }
}
