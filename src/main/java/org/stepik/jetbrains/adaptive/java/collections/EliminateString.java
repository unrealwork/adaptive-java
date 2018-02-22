package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Scanner;

public class EliminateString {

  static String eliminatePairs(String s) {
    // Complete this function
    String cur = reduce(s);
    return cur;
  }

  static String reduce(String s) {
    StringBuilder sb = new StringBuilder();
    Character previous = null;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (previous != null) {
        if (previous.equals(c)) {
          previous = null;
        } else {
          sb.append(previous);
          previous = c;
        }
      } else {
        previous = c;
      }
    }
    if (previous != null) {
      sb.append(previous);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = eliminatePairs(s);
    System.out.println(result);
  }
}
