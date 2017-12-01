package org.stepik.jetbrains.adaptive.java.ds;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by Shmagrinsky on 21.06.2017.
 */
public class QueueCreation {

  public static void main(String[] args) {

    //write your code here
    ArrayDeque<Integer> queue = new ArrayDeque<>(Arrays.asList(2, 0, 1, 7));

    System.out.println(queue);

  }
}
