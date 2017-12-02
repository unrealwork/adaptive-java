package org.stepik.csc.algorithms.divcon;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SegmentCount {

  /**
   * Main entry.
   *
   * @param args program args.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int segmentsCount = in.nextInt();
    final int pointsCount = in.nextInt();

    Segment[] segments = IntStream.range(0, segmentsCount)
        .mapToObj(i -> new Segment(in.nextInt(), in.nextInt()))
        .toArray(Segment[]::new);

    int[] points = IntStream.range(0, pointsCount)
        .map(i -> in.nextInt()).toArray();

    solve(segments, points).forEach(i -> System.out.printf("%d ", i));
  }

  public static List<Integer> solve(Segment[] segments, int[] points) {
    Integer[] starts = Arrays.stream(segments)
        .map(s -> s.start)
        .sorted()
        .toArray(Integer[]::new);
    Integer[] ends = Arrays.stream(segments)
        .map(s -> s.end)
        .sorted()
        .toArray(Integer[]::new);
    return Arrays.stream(points).boxed()
        .map(p -> count(starts, p, false) - count(ends, p, true))
        .collect(Collectors.toList());
  }

  private static <T extends Comparable<T>> int count(T[] a, T bound, int l,
      int r, boolean isLess) {
    if (r < l) {
      return l;
    } else {
      final int mid = (r - l) / 2 + l;
      final int cmp = bound.compareTo(a[mid]);
      if (cmp == 0) {
        if (isLess) {
          int res = mid;
          while (res >= 0 && bound.equals(a[res])) {
            res--;
          }
          if (res < 0) {
            return 0;
          } else {
            return res + 1;
          }
        } else {
          int res = mid;
          while (res < a.length && bound.equals(a[res])) {
            res++;
          }
          if (res == a.length) {
            return a.length;
          } else {
            return res;
          }
        }
      } else if (cmp > 0) {
        return count(a, bound, mid + 1, r, isLess);
      } else {
        return count(a, bound, l, mid - 1, isLess);
      }
    }
  }

  public static <T extends Comparable<T>> int count(T[] a, T el,
      boolean isLeft) {
    return count(a, el, 0, a.length - 1, isLeft);
  }

  static class Segment {

    private int start;
    private int end;

    Segment(int a, int end) {
      this.start = a;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Segment segment = (Segment) o;
      return start == segment.start
          && end == segment.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(start, end);
    }
  }
}
