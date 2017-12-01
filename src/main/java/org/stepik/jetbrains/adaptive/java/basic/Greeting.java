package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class Greeting {

  private static final Scanner SC = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Enter your name: ");
    final String name = SC.nextLine();
    System.out.println(String.format("Hello %s", name));
  }
}
