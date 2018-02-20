package org.stepik.jetbrains.adaptive.java.basic.arrays;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxPairwise {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    PriorityQueue<Integer> numbers = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
    for (int i = 0; i < size; i++) {
      numbers.add(sc.nextInt());
    }
    System.out.println(solve(numbers));
  }

  private static long solve(PriorityQueue<Integer> numbers) {
    if (numbers.size() < 2) {
      return numbers.remove();
    } else {
      return numbers.remove() * numbers.remove();
    }
  }
}
