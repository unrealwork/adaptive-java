package org.stepik.jetbrains.adaptive.java.basic;

public class InverseFlags {
  public static void inverseFlags(boolean[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = !arr[i];
    }
  }
}
