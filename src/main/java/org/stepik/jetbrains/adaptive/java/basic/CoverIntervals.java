package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class CoverIntervals {

  static Set<Segment> readData(InputStream is) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(is))) {
      Scanner scanner = new Scanner(reader);
      int size = scanner.nextInt();
      Set<Segment> result = new HashSet<>();
      for (int i = 0; i < size; i++) {
        result.add(new Segment(scanner.nextInt(), scanner.nextInt()));
      }
      return result;
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  static void printResult(OutputStream os, List<Double> points) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(
        new OutputStreamWriter(os))) {
      bufferedWriter.write(String.format("%d%n", points.size()));
      for (Double point : points) {
        bufferedWriter.write(String.format("%.0f ", point));
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  static List<Double> solve(Set<Segment> segmentSet) {
    List<Segment> segments = new ArrayList<>(segmentSet);
    Collections.sort(segments);
    List<Double> points = new LinkedList<>();
    while (!segments.isEmpty()) {
      Segment segment = segments.get(0);
      Segment currentSegment = segments.get(0);
      double point = currentSegment.right;
      points.add(point);
      segments.remove(segment);
      Collection<Segment> setToRemove = new HashSet<>();
      for (Segment s : segments) {
        if (s.isContain(point)) {
          setToRemove.add(s);
        }
      }
      segments.removeAll(setToRemove);
    }
    Collections.sort(points);
    return points;
  }

  public static void main(String[] args) {
    Set<Segment> data = readData(System.in);
    printResult(System.out, solve(data));
  }

  private static class Segment implements Comparable<Segment> {

    private double left;
    private double right;

    private Segment(double left, double right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return String.format("[%f, %f]", left, right);
    }

    public boolean isContain(Double point) {
      return point >= left && point <= right;
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

      if (Double.compare(segment.left, left) != 0) {
        return false;
      }
      return Double.compare(segment.right, right) == 0;
    }

    @Override
    public int hashCode() {
      int result;
      long temp;
      temp = Double.doubleToLongBits(left);
      result = (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(right);
      result = 31 * result + (int) (temp ^ (temp >>> 32));
      return result;
    }

    @Override
    public int compareTo(Segment s) {
      if (right > s.right) {
        return 1;
      } else {
        if (s.right == right) {
          return Double.compare(s.left, left);
        } else {
          return -1;
        }
      }
    }
  }
}
