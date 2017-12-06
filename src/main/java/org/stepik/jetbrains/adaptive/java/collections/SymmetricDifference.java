package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SymmetricDifference {

  public static Set<Integer> symDifference(Set<Integer> set1,
      Set<Integer> set2) {
    return Stream.concat(set1.stream().filter(e -> !set2.contains(e)),
        set2.stream().filter(e -> !set1.contains(e)))
        .collect(Collectors.toSet());
  }
}
