package org.stepik.jetbrains.adaptive.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseOrder {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      int size = Integer.parseInt(reader.readLine());
      List<String> words = IntStream.range(0, size).mapToObj(i -> {
        try {
          return reader.readLine();
        } catch (IOException e) {
          throw new IllegalArgumentException(e);
        }
      }).collect(Collectors.toList());
      Collections.reverse(words);
      words.forEach(System.out::println);
    } catch (IOException e) {

    }
  }
}
