package com.unrealwork.adaptive.java.generics;

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
