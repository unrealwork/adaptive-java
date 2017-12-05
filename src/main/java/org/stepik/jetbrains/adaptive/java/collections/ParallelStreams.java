package org.stepik.jetbrains.adaptive.java.collections;

import java.util.stream.LongStream;

public class ParallelStreams {

  public static LongStream createPrimesFilteringStream(long rangeBegin,
      long rangeEnd) {
    return LongStream.rangeClosed(rangeBegin, rangeEnd)
        .parallel()
        .filter(NumberUtils::isPrime);
  }

  private static class NumberUtils {

    public static boolean isPrime(long l) {
      return false;
    }
  }
}
