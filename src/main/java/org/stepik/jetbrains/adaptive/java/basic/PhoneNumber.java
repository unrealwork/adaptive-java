package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class PhoneNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String number = in.next();
    System.out.println(solve(number) ? "Yes" : "No");
    in.close();
  }

  private static boolean solve(String number) {
    return number.matches("19\\d{9}");
  }
}
