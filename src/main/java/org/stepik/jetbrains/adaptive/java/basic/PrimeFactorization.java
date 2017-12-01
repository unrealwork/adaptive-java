package org.stepik.jetbrains.adaptive.java.basic;

import static java.util.Collections.singletonList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrimeFactorization {


  private static List<Integer> factorization(Integer i) {
    final List<Integer> result = new ArrayList<>();
    final Set<Integer> primes = new HashSet<>(singletonList(2));
    int j;
    if (i < 2) {
      throw new IllegalArgumentException();
    } else {
      int currentPrime = 2;
      int rest = i;
      while (rest != 1) {
        while (rest % currentPrime == 0) {
          rest /= currentPrime;
          result.add(currentPrime);
        }
        j = currentPrime + 1;
        while (!isPrime(primes, j)) {
          j++;
        }
        primes.add(j);
        currentPrime = j;
      }
      return result;
    }
  }

  private static boolean isPrime(Set<Integer> result, int j) {
    return result.stream().allMatch(p -> j % p != 0);
  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      final int n = Integer.parseInt(reader.readLine());
      List<Integer> factoried = factorization(n);
      String res = factoried.stream().map(Object::toString).collect(Collectors.joining(" "));
      System.out.println(res);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
