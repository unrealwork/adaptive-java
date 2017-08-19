package com.unrealwork.adaptive.java.problems;

import java.util.Scanner;

/**
 * Given real numbers a, b, c, where a ≠ 0.
 * <p>Solve the quadratic equation ax2 + bx + c = 0 and output all of its roots.</p>
 * <p>If the equation has two roots, output these two roots in ascending order;
 * if one root - output a single number; if no roots – do not output anything.</p>
 */
public class QuadraticEquation {
  /**
   * Solve quadratic equation.
   *
   * @param a - first
   * @param b - second
   * @param c - third
   * @return Result object
   */
  public static Result solve(double a, double b, double c) {
    double d = b * b - 4 * a * c;
    if (d < 0) {
      return null;
    } else {
      double sqrtD = Math.sqrt(d);
      return new Result((-b - sqrtD) / (2 * a), (-b + sqrtD) / (2 * a));
    }
  }

  /**
   * Main method.
   * @param args without.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double a = in.nextDouble();
    double b = in.nextDouble();
    double c = in.nextDouble();

    Result result = solve(a, b, c);
    if (result != null) {
      System.out.println(result);
    }
  }

  public static class Result {
    private double first;
    private double second;

    Result(double first, double second) {
      this.first = Math.min(first, second);
      this.second = Math.max(first, second);
    }

    public double getFirst() {
      return first;
    }

    public double getSecond() {
      return second;
    }

    @Override
    public String toString() {
      if (Double.compare(first, second) == 0) {
        return Double.toString(first);
      } else {
        return String.format("%f %f", first, second);
      }
    }
  }
}
