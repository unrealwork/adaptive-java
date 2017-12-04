package org.stepik.jetbrains.adaptive.java.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEntries {

  public static void main(String[] args) {

    Map<String, Integer> map = new TreeMap<>();
    map.put("Gamma", 3);
    map.put("Omega", 24);
    map.put("Alpha", 1);

    //write your code here
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(String.format("%s=%d", entry.getKey(), entry.getValue()));
    }
  }
}
