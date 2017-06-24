package com.unrealwork.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shmagrinsky on 23.06.2017.
 */
public class HipHop {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> list = Arrays.stream(reader.readLine().split("\\s")).collect(Collectors.toList());

    //paste your code here
    for (String s: list) {
      System.out.println(s);
      if (s.equals("Hip")) {
        System.out.println("Hop");
      }
    }
  }
}
