package com.unrealwork.adaptive.java.ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * Created by Shmagrinsky on 23.06.2017.
 */
public class ListCreation {


  public static void main(String[] args) {
    long x = 1;
    long y = 4;
    long r = LongStream.rangeClosed(1, 4).reduce((left, right) -> left * right).getAsLong();
    List<Integer> list = Arrays.asList(2, 0, 1, 7);
    System.out.println(list);
  }
}
