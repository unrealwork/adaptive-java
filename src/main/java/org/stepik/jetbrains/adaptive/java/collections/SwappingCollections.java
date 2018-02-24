package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SwappingCollections {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());
    int swapSzie = scanner.nextInt();
    for (int i = 0; i < swapSzie; i++) {
      int first = scanner.nextInt();
      int second = scanner.nextInt();
      Collections.swap(list, first, second);
    }
    list.forEach(e -> System.out.printf("%d ", e));
  }
}
