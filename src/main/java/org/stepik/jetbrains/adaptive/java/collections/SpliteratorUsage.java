package org.stepik.jetbrains.adaptive.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorUsage {


  public static void main(String[] args) {
    print(spliteratorWork(Arrays.asList(4d, 4d, 4d, 100d, 100d, 100d)));
  }

  public static List<Double> spliteratorWork(List<Double> lst) {
    List<Double> sqrs = new ArrayList<>();
    Spliterator<Double> split = lst.spliterator();

    Spliterator<Double> firstPartIt = split.trySplit();
    firstPartIt.forEachRemaining(d -> {
      sqrs.add(Math.sqrt(d));
    });
    split.forEachRemaining(d -> {
      sqrs.add(Math.sqrt(d));
    });
    return sqrs;
  }

  public static void print(List<Double> list) {
    final Spliterator<Double> split = list.spliterator();
    split.trySplit().forEachRemaining(d -> {
      if (d >= 2) {
        System.out.println(d);
      }
    });
    System.out.println();
    split.forEachRemaining(d -> {
      if (d >= 10) {
        System.out.println(d);
      }
    });
  }
}
