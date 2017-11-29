package com.unrealwork.adaptive.java.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsSquaresProduct {

  private static int solve(List<Integer> list) {
    return list.stream().collect(Collectors.reducing(1,
        (a, b) -> a * b * b
    ));
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3);
    System.out.println(solve(list));
  }
}
