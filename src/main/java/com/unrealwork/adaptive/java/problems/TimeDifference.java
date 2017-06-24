package com.unrealwork.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class TimeDifference {

  private static class Time {

    private int hours;
    private int minutes;
    private int seconds;

    private Time(int hours, int minutes, int seconds) {
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
    }

    public int toSeconds() {
      return 3600 * hours + 60 * minutes + seconds;
    }

    public int diff(Time other) {
      return Math.abs(toSeconds() - other.toSeconds());
    }
  }

  private static int readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner in = new Scanner(reader);
      Time time1 = new Time(in.nextInt(), in.nextInt(), in.nextInt());
      Time time2 = new Time(in.nextInt(), in.nextInt(), in.nextInt());
      return time1.diff(time2);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static int solve(int diff) {
    return diff;
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
