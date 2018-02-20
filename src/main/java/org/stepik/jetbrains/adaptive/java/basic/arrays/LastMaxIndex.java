package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.Arrays;

public class LastMaxIndex {
  public static int findIndexOfLastMax(int[] numbers) {
    if (numbers.length == 0) {
      return -1;
    } else {
      int max = Arrays.stream(numbers).max().getAsInt();
      int i;
      for (i = numbers.length - 1; numbers[i] != max; i--) {

      }
      return i;
    }
  }
}
