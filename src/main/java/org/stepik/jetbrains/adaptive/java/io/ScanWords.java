package org.stepik.jetbrains.adaptive.java.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScanWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> words = words(sc.nextLine(), 5);
    words.forEach(System.out::println);
    if (sc.hasNext() && words.size() < 5) {
      words(sc.nextLine(), 5 - words.size())
          .forEach(System.out::println);
    }
  }

  public static List<String> words(String words, int limit) {
    return Arrays.stream(words.split(" "))
        .filter(s -> s.length() > 0)
        .limit(limit)
        .collect(Collectors.toList());
  }
}
