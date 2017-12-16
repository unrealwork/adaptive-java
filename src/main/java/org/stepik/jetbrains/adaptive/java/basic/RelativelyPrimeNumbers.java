package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RelativelyPrimeNumbers {


  private static List<Integer> primesDividers(int n) {
    Stack<Integer> stack = new Stack<>();
    int i = 2;
    int sqrt = (int) Math.ceil(Math.sqrt(n));
    boolean[] primes = new boolean[sqrt + 1];
    Arrays.fill(primes, true);
    while (i <= sqrt) {
      int step = i;
      if (n % i == 0) {
        stack.push(i);
      }
      for (int j = i + step; j < sqrt; j += step) {
        primes[j] = false;
      }
      if (i <= sqrt) {
        do {
          i++;
        } while (i <= sqrt && !primes[i]);
      }
    }
    int lastPrime = n;
    for (Integer prime : stack) {
      while (lastPrime % prime == 0) {
        lastPrime /= prime;
      }
    }
    if (lastPrime > 1) {
      stack.push(lastPrime);
    }
    return stack;
  }

  private static long solve(int n) {
    long result = n;
    List<Integer> primes = primesDividers(n);
    for (Integer prime : primes) {
      result = result / prime * (prime - 1);
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(solve(in.nextInt()));
    in.close();
  }
}
