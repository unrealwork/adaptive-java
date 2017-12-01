package org.stepik.csc.algorithms.divcon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {

  private static <T extends Comparable<T>> int find(T[] a, T el, int l, int r) {
    if (r < l) {
      return -1;
    } else {
      final int mid = (r - l) / 2 + l;
      final int cmp = el.compareTo(a[mid]);
      if (cmp == 0) {
        return 1 + mid;
      } else if (cmp > 0) {
        return find(a, el, mid + 1, r);
      } else {
        return find(a, el, l, mid - 1);
      }
    }
  }

  public static <T extends Comparable<T>> int find(T[] a, T el) {
    return find(a, el, 0, a.length - 1);
  }

  public static void main(String[] args) {
    final Scanner in = new Scanner(System.in);
    final int arraySize = in.nextInt();
    final Integer[] arr = IntStream.range(0, arraySize)
        .map(i -> in.nextInt()).boxed()
        .toArray(Integer[]::new);
    final int queriesSize = in.nextInt();
    IntStream.range(0, queriesSize).map(i -> find(arr, in.nextInt()))
        .forEach(index -> System.out
            .format("%d ", index));
  }
}
