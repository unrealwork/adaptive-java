package org.stepik.csc.algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestNotDecreasingSequence {


  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      final int size = Integer.parseInt(reader.readLine());
      int[] nums = Arrays.stream((reader.readLine()).split("\\s"))
          .mapToInt(Integer::parseInt).toArray();
      int[] sequnce = solve(nums);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static int[] solve(int[] nums) {
    return null;
  }
}
