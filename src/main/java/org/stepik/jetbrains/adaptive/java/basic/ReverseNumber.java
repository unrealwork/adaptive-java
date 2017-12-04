package org.stepik.jetbrains.adaptive.java.basic;


import java.util.Scanner;

public class ReverseNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder sb = new StringBuilder(in.next());
    System.out.println(sb.reverse().toString());
  }
}
