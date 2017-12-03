package org.stepik.csc.algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LargestIncreasingSequence {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] nums = IntStream.range(0, in.nextInt())
        .map(i -> in.nextInt()).toArray();
    System.out.println(solve(nums));
    in.close();
  }

  private static int solve(int[] nums) {
    int d[] = new int[nums.length];
    Arrays.fill(d, 1);
    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (d[j] + 1 > d[i]) {
            d[i] = d[j] + 1;
          }
        }
      }
      if (d[i] > res) {
        res = d[i];
      }
    }
    return res;
  }
}
