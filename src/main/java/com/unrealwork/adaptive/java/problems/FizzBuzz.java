package com.unrealwork.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FizzBuzz {

  private static class Range {

    private final int start;
    private final int end;


    private Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  private static Range readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      return new Range(scanner.nextInt(), scanner.nextInt());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static List<String> solve(Range data) {
    return LongStream.rangeClosed(data.start, data.end).boxed().map(i -> {
          boolean isMultipleThree = (i % 3 == 0);
          boolean isMultipleFive = (i % 5 == 0);
          String next;
          if (isMultipleThree && isMultipleFive) {
            next = "FizzBuzz";
          } else {
            if (isMultipleThree) {
              next = "Fizz";
            } else {
              if (isMultipleFive) {
                next = "Buzz";
              } else {
                next = Long.toString(i);
              }
            }
          }
          return next;
        }
    )
        .collect(Collectors.toList());
  }

  private static void printResult(OutputStream os, List<String> list) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      for (String s : list) {
        bufferedWriter.write(String.format("%s%n", s));
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }
}
