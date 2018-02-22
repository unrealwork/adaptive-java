package org.stepik.jetbrains.adaptive.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EvenOdd {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < size; i++) {
      int number = sc.nextInt();
      if (number % 2 == 0) {
        deque.addFirst(number);
      } else {
        deque.addLast(number);
      }
    }

    deque.forEach(System.out::println);
  }
}
