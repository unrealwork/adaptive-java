package org.stepik.jetbrains.adaptive.java.generics;

import java.util.ArrayDeque;
import java.util.Deque;

class Orange extends Fruit implements Comparable<Orange> {

  public Orange(int weight) {
    super(weight);
  }

  @Override
  public int compareTo(Orange o) {
    return Integer.compare(this.getWeigth(), o.getWeigth());
  }

  public static void main(String[] args) {
    Deque<String> states = new ArrayDeque<String>();

    states.add("Germany");
    states.add("France");
    states.push("UK");
    states.offerLast("Norway");

    String sFirst = states.pop();
    String s = states.peek();
    String sLast = states.peekLast();
    states.offer(sFirst);
    String s1 = states.pollLast();

    while (states.peek() != null) {
      System.out.print(states.pop());
    }
  }
}