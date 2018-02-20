package org.stepik.jetbrains.adaptive.java.functional;

import java.util.function.BiFunction;
import java.util.function.Function;
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

  Function<Integer, Integer> a = (a) -> a;

  BiFunction<Integer, Integer, Function<Integer, Integer>> c = (a, b) -> (c -> c);

  BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>> cur = (a, b) -> (c, d) -> e -> a + b + c;
}
