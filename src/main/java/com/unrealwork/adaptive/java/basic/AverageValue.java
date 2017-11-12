package com.unrealwork.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageValue {

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      double sum = 0;
      int number = Integer.parseInt(reader.readLine());
      int count = 0;
      while (number != 0) {
        sum += number;
        count++;
        number = Integer.parseInt(reader.readLine());
      }
      System.out.println(sum/count);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
