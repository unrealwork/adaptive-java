package com.unrealwork.adaptive.java.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ChessBoard {

  private static Queen[] readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      return new Queen[]{new Queen(scanner.nextInt(), scanner.nextInt()),
          new Queen(scanner.nextInt(), scanner.nextInt())};
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static boolean solve(Queen[] positions) {
    return positions[0].isBeat(positions[1]);
  }

  private static void printResult(OutputStream os, boolean isIntersect) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      bufferedWriter.write(isIntersect ? "YES" : "NO");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }

  private static class Queen {

    private int x;
    private int y;

    private Queen(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean isBeat(Queen other) {
      return (x == other.x || y == other.y) || (Math.abs(x - other.x) == Math
          .abs(y - other.y));
    }
  }
}
