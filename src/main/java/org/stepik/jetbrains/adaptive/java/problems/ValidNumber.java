package org.stepik.jetbrains.adaptive.java.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ValidNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String number = in.next();
    System.out.println(solve(number) ? "Yes" : "No");
    in.close();
  }

  private static boolean solve(String number) {
    final List<Character> validLetters = Arrays
        .asList('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X');
    final int validLength = 6;
    if (number.length() != validLength) {
      return false;
    }

    for (int i = 0; i < validLength; i++) {
      char c = number.charAt(i);
      if (i < 1 || i > 3) {
        if (!validLetters.contains(c)) {
          return false;
        }
      } else {
        if (!Character.isDigit(c)) {
          return false;
        }
      }
    }
    return true;
  }
}
