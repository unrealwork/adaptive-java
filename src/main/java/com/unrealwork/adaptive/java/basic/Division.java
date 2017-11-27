package com.unrealwork.adaptive.java.basic;

import java.util.Scanner;

public class Division {

  private static boolean isDivided(String n) {
    return n.chars().map(c -> c - '0').sum() % 3 == 0;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(isDivided(in.nextLine()) ? "YES" : "NO");
    in.close();
  }
}
