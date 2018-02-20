package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LongestAscendingSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(solve(arr));
  }

  private static int solve(int[] arr) {
    int[] d = new int[arr.length];
    d[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      int maxLength = d[i - 1];
      int j = i - 1;
      while (j > -1 && d[j] == maxLength) {
        j--;
      }
      j++;
      d[i] = (arr[j] < arr[i]) ? d[j] + 1 : d[j];
    }
    return Arrays.stream(d).max().getAsInt();
  }
}
