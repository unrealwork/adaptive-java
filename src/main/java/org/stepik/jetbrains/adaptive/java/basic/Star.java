package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star {

  private static int readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      return scanner.nextInt();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static char[][] solve(int size) {
    char[][] result = new char[size][size];
    int middle = size / 2;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = (i == middle || j == middle || i == j || i + j + 1 == size) ? '*' : '.';
      }
    }
    return result;
  }

  private static void printResult(OutputStream os, char[][] matrix) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          bufferedWriter.write(String.format("%c ",matrix[i][j]));
        }
        bufferedWriter.write(String.format("%n"));
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  public static void main(String[] args) {
    printResult(System.out, solve(readData(System.in)));
  }

}
