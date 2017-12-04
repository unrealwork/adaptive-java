package org.stepik.jetbrains.adaptive.java.collections;

/**
 * Created by Shmagrinsky on 21.06.2017.
 */
class Box<T> {

  private T item;

  public void put(T item) {
    this.item = item;
  }

  public T get() {
    return this.item;
  }

}
