package org.stepik.csc.algorithms.heaps;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PriorityQueueUsage {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int actionsCount = Integer.parseInt(in.nextLine());
    PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> -Integer.compare(a, b));
    IntStream.range(0, actionsCount).forEach(
        i -> {
          final String action = in.nextLine();
          if (action.startsWith("Insert")) {
            queue.add(Integer.parseInt(action.split("\\s")[1]));
          } else {
            System.out.println(queue.poll());
          }
        }
    );
    in.close();
  }
}
