package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListBasic {

  public static Integer maxElem(List<Integer> list) {
    return list.stream().max(Integer::compareTo).orElse(null);
  }

  public static List<String> changeList(List<String> list) {
    final String longest = Collections
        .max(list, Comparator.comparingInt(String::length));
    return list.stream().map(s -> longest).collect(Collectors.toList());
  }
}
