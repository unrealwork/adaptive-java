package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    List<String> list = Arrays.stream(reader.readLine().split(" "))
        .filter(s -> s.startsWith("J")).map(s -> s.substring(1))
        .collect(
            Collectors.toList());
    //enter your code here
    Collections.reverse(list);
    list.forEach(System.out::println);
  }

  public static List<String> noLongString(List<String> strings) {
    return strings.stream().filter(s -> s.length() < 4)
        .collect(Collectors.toList());
  }
}
