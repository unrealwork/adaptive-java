package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Residents of the Malevia country often experiment with the plan of their
 * rooms. Rooms can be triangular, rectangular and round. To quickly calculate
 * the floorage it is required to write a program, which gets the type of the
 * room shape and the relevant parameters as input - the program should output
 * the area of the resulting room. <p>The value of 3.14 is used instead of the
 * number π in Malevia. </p>
 * <p>
 * Input format used by the Malevians:
 * <p>
 * <pre>
 *   triangle
 *   a
 *   b
 *   c
 * </pre>
 */
public class FloorspaceRoom {

  private static final double PI = 3.14d;

  enum ShapeType {
    TRIANGLE("triangle"), RECTANGLE("rectangle"), CIRCLE("circle");

    private final String type;

    ShapeType(final String type) {
      this.type = type;
    }

    public static ShapeType getByType(final String type) {
      for (ShapeType value : values()) {
        if (value.type.equals(type)) {
          return value;
        }
      }
      throw new IllegalArgumentException();
    }
  }

  public interface Shape {

    double area();

    ShapeType getType();
  }

  public final static class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public double getC() {
      return c;
    }

    public double getB() {
      return b;
    }

    public double getA() {
      return a;
    }

    @Override
    public double area() {
      final double p = (a + b + c) / 2;
      return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public ShapeType getType() {
      return ShapeType.TRIANGLE;
    }
  }

  public final static class Circle implements Shape {

    private double r;

    public Circle(double r) {
      this.r = r;
    }

    public double getRadius() {
      return r;
    }

    @Override
    public double area() {
      return r * r * PI;
    }

    @Override
    public ShapeType getType() {
      return ShapeType.CIRCLE;
    }
  }


  public static class Rectangle implements Shape {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public double area() {
      return a * b;
    }

    @Override
    public ShapeType getType() {
      return ShapeType.RECTANGLE;
    }

    public double getA() {
      return a;
    }

    public double getB() {
      return b;
    }

  }

  /**
   * Entry point.
   *
   * @param args program arguments;
   */
  public static void main(final String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      ShapeType type = ShapeType.getByType(reader.readLine());
      final double a = readDouble(reader);
      Shape shape;
      switch (type) {
        case CIRCLE:
          shape = new Circle(a);
          break;
        case RECTANGLE:
          shape = new Rectangle(a, readDouble(reader));
          break;
        case TRIANGLE:
          shape = new Triangle(a, readDouble(reader), readDouble(reader));
          break;
        default:
          throw new IllegalStateException();
      }
      System.out.println(shape.area());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static double readDouble(final BufferedReader reader)
      throws IOException {
    return Double.parseDouble(reader.readLine());
  }
}
