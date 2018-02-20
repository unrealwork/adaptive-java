package org.stepik.jetbrains.adaptive.java.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> words = new ArrayList<>();
    while (sc.hasNext() || words.size() < 5) {
      words.add(sc.next());
    }
    words.forEach(System.out::println);
  }
}
