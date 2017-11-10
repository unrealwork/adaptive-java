package com.unrealwork.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorUsage {

  public static void main(String[] args) throws IOException {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final List<String> list = new LinkedList<>(Arrays.asList(reader.readLine().split(" ")));
    final ListIterator<String> it = list.listIterator();
    while (it.hasNext()) {
      final String value = it.next();
      if (!value.startsWith("J")) {
        it.remove();
      } else {
        it.set(value.substring(1));
      }
    }

    while (it.hasPrevious()) {
      System.out.println(it.previous());
    }
    reader.close();
  }
}
