package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class HeronFormula {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out
        .println(solve(in.nextDouble(), in.nextDouble(), in.nextDouble()));
    in.close();
  }

  private static double solve(double a, double b, double c) {
    final double p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }
}
