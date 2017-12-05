package org.stepik.jetbrains.adaptive.java.collections;

import java.util.List;

/**
 * Class to modify
 */
public class ListMultiplicator {

  /**
   * Multiplies original list provided numper of times
   *
   * @param list list to multiply
   * @param n times to multiply, should be zero or greater
   */
  public static void multiply(List<?> list, int n) {
    List a = new java.util.ArrayList(list);
    list.clear();
    for (int i = 0; i < n; i++) {
      list.addAll(a);
    }
  }
}
