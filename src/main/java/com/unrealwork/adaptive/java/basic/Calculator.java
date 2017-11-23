package com.unrealwork.adaptive.java.basic;

import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {

  private static Collection<Integer> calc(Integer start) {
    int rest = start;
    Stack<Integer> res = new Stack<>();
    res.push(start);
    while (rest != 1) {
      if (rest % 3 == 0) {
        rest /= 3;
      } else {
        if (rest % 2 == 0) {
          rest /= 2;
        } else {
          rest -= 1;
        }
      }
      res.add(rest);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Collection<Integer> result = calc(sc.nextInt());
    System.out.println(result.size() - 2);
    String res = result.stream().map(Object::toString)
        .collect(Collectors.joining(" "));
    System.out.println(res);
  }
}
