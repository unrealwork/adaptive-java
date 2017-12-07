package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapUsage {

  public static void main(String[] args) {
    SortedMap<String, Integer> map = wordCount("a b b c d a b".split(" "));
    printMap(map);
  }

  public static Map<String, String> mapShare(Map<String, String> map) {
    if (map.containsKey("a")) {
      map.put("b", map.get("a"));
    }
    map.remove("c");
    return map;
  }

  public static SortedMap<String, Integer> wordCount(String[] strings) {
    SortedMap<String, Integer> map = new TreeMap<>();
    for (String s : strings) {
      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }
    return map;
  }

  public static void printMap(Map<String, Integer> map) {
    for (Map.Entry<String, Integer> e : map.entrySet()) {
      System.out.format("%s : %s%n", e.getKey(), e.getValue());
    }
  }

  public static NavigableMap<Integer, String> getSubMap(
      NavigableMap<Integer, String> map) {
    final int key = map.firstEntry().getKey();
    if (key % 2 == 0) {
      return map.subMap(map.lastKey() - 4, true, map.lastKey(), true)
          .descendingMap();
    } else {
      return map.subMap(key, true, key + 4, true).descendingMap();
    }
  }
}
