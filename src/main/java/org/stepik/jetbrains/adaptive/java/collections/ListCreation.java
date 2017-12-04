package org.stepik.jetbrains.adaptive.java.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Shmagrinsky on 23.06.2017.
 */
public class ListCreation {


  public static void main(String[] args) {
    long x = 1;
    long y = 4;
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    long r = numbers.stream().collect(Collectors.reducing((Integer o,Integer o2) -> o + o2*o2)).get();
    System.out.println(r);
  }
}
