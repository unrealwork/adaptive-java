package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class CountSubstring {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String source = sc.nextLine();
    String substring = sc.nextLine();
    int index;
    int searchIndex = 0;
    int count = 0;
    do {
      index = source.indexOf(substring, searchIndex);
      if (index >= 0) {
        count++;
        searchIndex = index + 1;
      }
    } while (index >= 0);
    System.out.println(count);
  }
}
