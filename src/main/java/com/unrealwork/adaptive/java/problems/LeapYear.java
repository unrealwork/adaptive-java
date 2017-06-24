package com.unrealwork.adaptive.java.problems;

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
public class LeapYear {

  private static int readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      return scanner.nextInt();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static int gcd(int n, int m) {
    return (m == n) ? n : (m > n) ? gcd(m - n, n) : gcd(n - m, m);
  }

  private static boolean solve(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  private static void printResult(OutputStream os, boolean isLeap) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      bufferedWriter.write(isLeap ? "Leap" : "Regular");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }

}
