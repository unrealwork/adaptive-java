package org.stepik.jetbrains.adaptive.java.functional.filtering;

import java.util.List;
import java.util.stream.Collectors;

public class OmitLongStrings {
  public static List<String> omitLongStrings(List<String> strings) {

    return strings.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
  }
}
