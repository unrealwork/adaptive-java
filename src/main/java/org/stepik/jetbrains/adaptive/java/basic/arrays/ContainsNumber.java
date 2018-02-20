package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ContainsNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    int n = sc.nextInt();
    System.out.println(Arrays.asList(arr).contains(n));
  }
}
