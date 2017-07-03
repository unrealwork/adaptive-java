package com.unrealwork.adaptive.java.problems;

import java.util.Scanner;


public class Mkad {

  public static final int MKAD_LENGTH = 109;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int speed = in.nextInt();
    int h = in.nextInt();
    System.out.println(solve(speed, h));
    in.close();
  }

  private static int solve(int speed, int h) {
    int p = speed * h % MKAD_LENGTH;
    return (p < 0) ? p + MKAD_LENGTH : p;
  }
}
