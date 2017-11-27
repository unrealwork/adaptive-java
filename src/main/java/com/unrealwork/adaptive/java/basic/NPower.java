package com.unrealwork.adaptive.java.basic;

import java.util.Scanner;

public class NPower {

  static double pow(double a, int n) {
    if (n == 0) {
      return 1;
    } else if (n % 2 == 1) {
      return a * pow(a, n - 1);
    } else {
      return pow(a * a, n / 2);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(pow(in.nextDouble(), in.nextInt()));
    in.close();
  }
}
