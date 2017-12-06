package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetusage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    String[] sets = reader.readLine().split(";");

    Set<Integer> set1 = parseSet(sets[0]);
    //your code(add elements to set1 from sets[0])

    Set<Integer> set2 = parseSet(sets[1]);
    //your code(add elements to set2 from sets[1])

    Set<Integer> set3 = parseSet(sets[2]);
    //your code(add elements to set3 from sets[2])

    Set<Integer> resultTreeSet = unionTreeLargeNumber(set1, set2, set3);

    //print elements of resultTreeSet(using System.out.printLn()) below
    resultTreeSet.stream().forEach(System.out::println);

    LinkedHashSet set = new LinkedHashSet();

    int a = 0;
  }

  private static Set<Integer> parseSet(String set) {
    return Arrays.stream(set.split(" "))
        .map(Integer::parseInt).collect(Collectors.toSet());
  }

  public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1,
      Set<Integer> set2, Set<Integer> set3) {
    TreeSet<Integer> resultSet = new TreeSet<>(
        (a, b) -> -Integer.compare(a, b));
    resultSet.addAll(Arrays.asList(getMax(set1), getMax(set2), getMax(set3)));
    return resultSet;
  }

  private static Integer getMax(Set<Integer> set1) {
    return set1.stream().max(Integer::compareTo).orElse(null);
  }
}
