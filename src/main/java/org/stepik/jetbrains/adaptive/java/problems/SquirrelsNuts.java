package org.stepik.jetbrains.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Shmagrinsky on 23.06.2017.
 */
public class SquirrelsNuts {

  private static class InputData {

    private final int nuts;
    private final int squirrels;


    private InputData(int squirrels, int nuts) {
      this.nuts = nuts;
      this.squirrels = squirrels;
    }
  }

  private static InputData readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      return new InputData(scanner.nextInt(), scanner.nextInt());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static int solve(InputData data) {
    Set<Integer> set = new HashSet<>();
    return data.nuts / data.squirrels;
  }

  private static void printResult(OutputStream os, int result) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      bufferedWriter.write(String.format("%d", result));
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }
}
