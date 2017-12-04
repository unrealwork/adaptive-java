package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;


public class Desks {

  public static int groupDesks(int studentsCount) {
    return studentsCount / 2 + studentsCount % 2;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    System.out.println(groupDesks(a) + groupDesks(c) + groupDesks(b));
  }
}
