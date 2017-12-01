package org.stepik.jetbrains.adaptive.java.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by Shmagrinsky on 21.06.2017.
 */
public class QueueOperations {

  public static void main(String[] args) {

    Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4));

    //write your code here
    queue.add(5);
    queue.remove();
    queue.remove();

    System.out.println(queue);

  }
}
