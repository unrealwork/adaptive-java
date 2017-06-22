package com.unrealwork.adaptive.java.ds;

import java.util.Map;
import java.util.TreeMap;


public class TreeMapUsage {

  public static void main(String[] args) {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    map.put("Alpha", 1);
    map.put("Gamma", 3);
    map.put("Omega", 24);
    System.out.println(map);
  }
}
