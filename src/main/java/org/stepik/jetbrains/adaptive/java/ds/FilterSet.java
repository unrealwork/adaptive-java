package org.stepik.jetbrains.adaptive.java.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterSet {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = reader.readLine().split(" ");
    List<Integer> helpList = Arrays.stream(strings).map(Integer::parseInt)
        .collect(Collectors.toList());
    Set<Integer> set = new HashSet<>(helpList);
    //add elements from strings to set
    set.addAll(Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList()));
    //add elements from helpList to set
    set.addAll(helpList);
    set = removeAllNumbersMoreThan10(set);
    set.forEach(System.out::println);
  }

  public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set) {
    return set.stream().filter(n -> n < 10).collect(Collectors.toSet());
  }

}
