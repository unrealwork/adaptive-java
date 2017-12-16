package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class SumOfIntegers {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int start = in.nextInt();
    int end = in.nextInt();

    long sum = (end - start + 1) * (end + start) / 2;
    System.out.println(sum);
  }
}
