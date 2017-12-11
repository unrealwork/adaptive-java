package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class CollatzConjecture {

  private static void print(int n) {
    System.out.format("%d ", n);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int it = in.nextInt();
    print(it);
    while (it != 1) {
      if (it % 2 == 0) {
        it /= 2;
      } else {
        it = it * 3 + 1;
      }
      print(it);
    }
  }
}
