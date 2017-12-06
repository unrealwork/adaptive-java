package org.stepik.jetbrains.adaptive.java.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUsage {

  public static void main(String[] args) {
    Queue<String> queue = new PriorityQueue<>();
    queue.offer("a");
    queue.offer("c");
    queue.offer("b");

    String name = queue.peek();
    String name1 = queue.poll();
    String name2 = queue.poll();
    queue.offer(name);

    queue.forEach(System.out::print);
  }
}
