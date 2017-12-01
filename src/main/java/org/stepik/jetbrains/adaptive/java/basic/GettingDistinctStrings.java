package org.stepik.jetbrains.adaptive.java.basic;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GettingDistinctStrings {

  public static void main(String[] args) {
    Function<List<String>, List<String>> lambda = x -> x.stream().distinct()
        .collect(Collectors.toList());
  }
}
