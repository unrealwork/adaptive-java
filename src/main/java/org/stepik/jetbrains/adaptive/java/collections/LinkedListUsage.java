package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListUsage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    String str = reader.readLine();
    LinkedList<Integer> ll = new LinkedList<>();
    //your code
    Arrays.stream(str.split(" "))
        .map(Integer::parseInt).forEach(ll::addFirst);
    for (int i = 0; i < 3; i++) {
      ll.remove(0);
    }
    Collections.sort(ll);
    ll.stream().forEach(System.out::println);
  }
}
