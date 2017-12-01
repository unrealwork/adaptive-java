package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sorting {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    if (in.hasNext()) {
      int size = in.nextInt();
      final int[] a = new int[size];
      for (int i = 0; i < size; i++) {
        a[i] = in.nextInt();
      }
      final int[] solution = solve(a);
      System.out.println(
          IntStream.of(solution)
              .mapToObj(Integer::toString)
              .collect(Collectors.joining(" "))
      );
    }
  }

  private static int[] solve(int[] a) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < a.length; i++) {
      map.put(a[i], i + 1);
    }
    final int[] indexies = new int[a.length];
    int j = 0;
    map.forEach((e, i) -> {
      indexies[j] = i;
    });
    return indexies;
  }
}
