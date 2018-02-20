package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.Arrays;

public class FirstMinIndex {
  public static int findIndexOfMin(int[] numbers) {
    if (numbers.length == 0) {
      return -1;
    } else {
      int min = Arrays.stream(numbers).min().getAsInt();
      int i;
      for (i = 0; numbers[i] != min; i++) {

      }
      return i;
    }
  }
}
