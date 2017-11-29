package com.unrealwork.adaptive.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CollectorsGrouping {

  public static void main(String[] args) {
    String[] words = new String[]{"aa", "level", "aaa"};
    System.out.println(solve(words));
  }

  private static Map<Boolean, List<String>> solve(String[] words) {
    Function<String, Boolean> keyMapper = s -> new StringBuilder(s).reverse()
        .toString().equals(s);

    Function<String, List<String>> valueMapper = Arrays::asList;

    BinaryOperator<List<String>> mergeFuncton = (list, list1) -> {
      List<String> res = new ArrayList<>(list);
      res.addAll(list1);
      return res;
    };

    Supplier<Map<Boolean, List<String>>> mapSupplier = () -> new HashMap<Boolean, List<String>>() {{
      put(true, Collections.emptyList());
      put(false, Collections.emptyList());
    }};

    /*return Arrays.stream(words)
        .collect(Collectors
                .toMap(keyMapper, valueMapper, mergeFuncton, mapSupplier));
  }*/
    return Arrays.stream(words)
        .collect(Collectors
            .partitioningBy(s -> new StringBuilder(s).reverse().equals(s)));

  }
}