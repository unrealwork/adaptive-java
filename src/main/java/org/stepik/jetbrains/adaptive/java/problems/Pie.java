package org.stepik.jetbrains.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by Shmagrinsky on 24.06.2017.
 */
public class Pie {

  private static class InputData {

    private int m;
    private int n;

    private InputData(int m, int n) {
      this.m = m;
      this.n = n;
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

  private static int gcd(int n, int m) {
    return (m == n) ? n : (m > n) ? gcd(m - n, n) : gcd(n - m, m);
  }

  private static long solve(InputData data) {
    return data.m * data.n / gcd(data.m, data.n);
  }

  private static void printResult(OutputStream os, long lcm) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      bufferedWriter.write(String.format("%d%n", lcm));
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }
}
