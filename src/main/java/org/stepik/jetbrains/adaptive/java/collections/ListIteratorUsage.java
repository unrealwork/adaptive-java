package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ListIteratorUsage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    List<String> list = Arrays.stream(reader.readLine().split("\\s"))
        .collect(Collectors.toList());
    final String hip = "Hip";
    //paste your code here
    ListIterator<String> it = list.listIterator();
    while (it.hasNext()) {
      String value = it.next();
      if (hip.equals(value)) {
        it.add("Hop");
      }
    }

    list.forEach(System.out::println);
  }
}
