package com.unrealwork.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers {


  private static long readToSum(BufferedReader reader, int sum)
      throws IOException {
    final int n = Integer.parseInt(reader.readLine());
    if (n == 0) {
      reader.close();
      return sum;
    } else {
      return readToSum(reader, sum + n);
    }
  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      System.out.println(readToSum(reader, 0));
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }
}
