package org.stepik.jetbrains.adaptive.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseOrder {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      List<String> words = reader.lines().collect(Collectors.toList());
      Collections.reverse(words);
      words.forEach(System.out::println);
    } catch (IOException e) {

    }
  }
}
