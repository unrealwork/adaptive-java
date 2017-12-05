package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CurriingUsage {

  private static final UnaryOperator<List<Integer>> identity = x -> x;

  /**
   * The function accepts a list of mappers and returns an operator that accepts a list of integers
   * and sequentially applies each mapper to each value (perform a transformation)
   */
  public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
      l ->
          x -> x.stream()
              .map(item -> l.stream()
                  .reduce(s -> s, IntUnaryOperator::andThen)
                  .applyAsInt(item)
              )
              .collect(Collectors.toList());

  /**
   * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
   *
   * It returns a list of the same numbers.
   */
  public static final UnaryOperator<List<Integer>> identityTransformation =
      multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

  /**
   * The operator accepts an integer list.
   * It multiplies by two each integer number and then add one to its.
   *
   * The operator returns transformed integer list.
   */
  public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation = multifunctionalMapper
      .apply(
          Arrays.asList(x -> x * 2, x -> x + 1)
      );

  /**
   * The operator accepts an integer list.
   * It squares each integer number and then get the next even number following it.
   *
   * The operator returns transformed integer list.
   */
  public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation = multifunctionalMapper
      .apply(Arrays.asList(x -> x * x, x -> (x % 2 == 0) ? x + 2 : x + 1));

  public static void main(String[] args) {
    List<Integer> l = Arrays.asList(1, 1, 1, 1);
    List<Integer> l1 = Arrays.asList(1, 2, 3);
    System.out.println(identityTransformation.apply(l1));
    System.out.println(squareAndThenGetNextEvenNumberTransformation.apply(l1));
    System.out.println(multTwoAndThenAddOneTransformation.apply(l1));
  }
}
