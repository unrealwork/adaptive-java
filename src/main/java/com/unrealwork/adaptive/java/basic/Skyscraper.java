package com.unrealwork.adaptive.java.basic;

import java.util.Scanner;

public class Skyscraper {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(solve(in.nextInt() - 1, 0, 1));
    in.close();
  }

  private static long solve(int remains, int res, int step) {
    if (remains < 1) {
      return res;
    } else {
      return solve(remains - step, res + 1, step + 1);
    }
  }
}
