package com.unrealwork.adaptive.java;

import java.util.stream.LongStream;


public class PrimeChecker {

  public static boolean isPrime(final long number) {
    return LongStream.range(2, Math.round(Math.sqrt(number)) + 1).boxed()
        .allMatch(aLong -> number % aLong != 0);
  }
}
