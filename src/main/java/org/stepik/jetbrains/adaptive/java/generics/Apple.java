package org.stepik.jetbrains.adaptive.java.generics;

class Apple extends Fruit implements Comparable<Apple> {

  public Apple(int weight) {
    super(weight);
  }

  @Override
  public int compareTo(Apple o) {
    return Integer.compare(this.getWeigth(), o.getWeigth());
  }
}