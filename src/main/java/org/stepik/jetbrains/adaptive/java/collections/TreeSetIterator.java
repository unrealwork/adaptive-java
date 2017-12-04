package org.stepik.jetbrains.adaptive.java.collections;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetIterator {

  public static void main(String[] args) {

    Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

    //write your code here
    for (String name : nameSet) {
      System.out.println(name);
    }
  }
}
