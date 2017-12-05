package org.stepik.jetbrains.adaptive.java.collections;

import java.util.stream.IntStream;

public class NumbersFiltering {

  public static IntStream createFilteringStream(IntStream evenStream,
      IntStream oddStream) {
    return IntStream.concat(evenStream, oddStream)
        .filter(n -> n % 3 == 0 && n % 5 == 0).sorted().skip(2);
  }
}
