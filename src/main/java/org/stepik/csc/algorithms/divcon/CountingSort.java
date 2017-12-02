package org.stepik.csc.algorithms.divcon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CountingSort {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int[] sorter = new int[11];
    final int count = in.nextInt();
    IntStream.range(0, count).forEach(i -> {
      sorter[in.nextInt()]++;
    });
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sorter.length; i++) {
      for (int j = 0; j < sorter[i]; j++) {
        sb.append(i);
        sb.append(" ");
      }
    }
    System.out.println(sb);
    in.close();
  }
}
