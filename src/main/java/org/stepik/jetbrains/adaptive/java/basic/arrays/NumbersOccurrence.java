package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.Scanner;

public class NumbersOccurrence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int n = sc.nextInt();
    System.out.println(solve(arr, m, n));
  }

  private static boolean solve(int[] arr, int m, int n) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] == m && arr[i] == n
          || arr[i - 1] == n && arr[i] == m) {
        return true;
      }
    }
    return false;
  }
}
