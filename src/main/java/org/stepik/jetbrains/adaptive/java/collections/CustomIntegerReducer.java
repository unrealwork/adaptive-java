package org.stepik.jetbrains.adaptive.java.collections;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class CustomIntegerReducer {

  /**
   * The operator combines all values in the given range into one value
   * using combiner and initial value (seed)
   */
  public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
      (seed, f) -> (left, right) -> IntStream.rangeClosed(left, right)
          .reduce(seed, f);

  /**
   * The operator calculates the sum in the given range (inclusively)
   */
  public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0,(acc, cur) -> acc + cur);

  /**
   * The operator calculates the product in the given range (inclusively)
   */
  public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1,(acc, cur) -> acc
      * cur);

  public static void main(String[] args) {
    System.out
        .println(sumOperator.applyAsInt(1,4));
    System.out
        .println(productOperator.applyAsInt(5,7));
  }
}
