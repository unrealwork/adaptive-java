package com.unrealwork.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanSystem {

  private static final Map<Character, Integer> MAP = new HashMap<Character, Integer>() {{
    put('I', 1);
    put('V', 5);
    put('X', 10);
    put('L', 50);
    put('C', 100);
    put('D', 500);
    put('M', 1000);
  }};

  private static Integer convert(String romanNum) {
    int res = 0;
    int lastDigit = Integer.MAX_VALUE;
    int currentCatecogory = 0;
    for (int i = 0; i < romanNum.length(); i++) {
      char digit = romanNum.charAt(i);
      int d = MAP.get(digit);
      if (lastDigit != d) {
        if (d > lastDigit) {
          res += (d - currentCatecogory);
          currentCatecogory = 0;
        } else {
          res += currentCatecogory;
          currentCatecogory = d;
        }
      } else {
        currentCatecogory += d;
      }
      lastDigit = d;
    }
    res += currentCatecogory;
    return res;
  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println(convert(reader.readLine()));
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
