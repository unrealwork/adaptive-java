package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class RootsOfEquation {

  private static long polynom(int[] coefficients, int x) {
    long result = 0;
    long poweredX = 1;
    int lastIndex = coefficients.length - 1;
    for (int i = lastIndex; i >= 0; i--) {
      result += (poweredX * coefficients[i]);
      poweredX *= x;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] coef = new int[4];
    for (int i = 0; i < 4; i++) {
      coef[i] = in.nextInt();
    }

    for (int i = 0; i < 1000; i++) {
      if (polynom(coef, i) == 0) {
        System.out.println(i);
      }
    }
  }
}
