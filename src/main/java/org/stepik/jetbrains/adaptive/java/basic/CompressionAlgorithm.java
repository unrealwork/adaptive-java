package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class CompressionAlgorithm {


  private static String solve(String str) {
    final StringBuilder sb = new StringBuilder(
        Character.toString(str.charAt(0)));
    int repeatCount = 1;
    for (int i = 1; i < str.length(); i++) {
      char c = str.charAt(i);
      int length = sb.length();
      if (length > 0 && sb.charAt(length - 1) == c) {
        repeatCount++;
      } else {
        sb.append(repeatCount).append(c);
        repeatCount = 1;
      }
    }
    sb.append(repeatCount);
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(solve(in.nextLine()));
    in.close();
  }
}
