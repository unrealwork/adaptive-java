package com.unrealwork.adaptive.java.collections;

import java.util.List;

public class ArrayListBasic {

  public static Integer maxElem(List<Integer> list) {
    return list.stream().max(Integer::compareTo).orElse(null);
  }
}
