package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class IteratorUsage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    //lets go
    Collection<Integer> c = Arrays.stream(reader.readLine().split(" "))
        .map(Integer::parseInt).sorted().collect(
            Collectors.toList());
    c.removeIf(n -> n % 2 == 0);
    c.forEach(System.out::println);
  }
}
