package org.stepik.jetbrains.adaptive.java.io;

import java.util.Scanner;

public class StdInOut {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.printf("%d %d%n", b, a);
  }
}
