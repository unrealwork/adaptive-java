package com.unrealwork.adaptive.java.basic;

import java.util.Scanner;

public class Snail {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int a = in.nextInt();
    int d = in.nextInt();
    System.out.println(solve(h, a, d));
    in.close();
  }

  private static long solve(int h, int a, int d) {
    int acc = 0;
    int days = 0;
    while (acc < h) {
      days++;
      acc += a;
      if (acc >= h) {
        return days;
      }
      acc -= d;
    }
    return days;
  }
}
