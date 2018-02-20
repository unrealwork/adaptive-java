package org.stepik.jetbrains.adaptive.java.basic;

import java.util.stream.Stream;

public class Main {
  public static void main(String... args) {
    Stream<Dog> str = Stream.of(new Dog(10), new Dog(20), new Dog(30));
    str.peek(x -> x.width++).forEach(System.out::println);
  }

  static class Dog {
    float width;

    public Dog(float width) {
      this.width = width;
    }

    @Override
    public String toString() {
      return width + "";
    }
  }
}

