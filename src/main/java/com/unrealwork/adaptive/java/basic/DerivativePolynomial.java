package com.unrealwork.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DerivativePolynomial {

  public static class PolynomialMember {

    private final Integer degree;
    private final Integer coef;

    PolynomialMember(Integer coef, Integer degree) {
      this.coef = coef;
      this.degree = degree;
    }

    public static PolynomialMember member(Integer coef, Integer degree) {
      return new PolynomialMember(coef, degree);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      //coef
      if (coef == -1) {
        sb.append('-');
      } else if (coef == 1) {
        if (degree == 0) {
          sb.append('1');
        }
      } else {
        sb.append(coef);
        if (degree != 0) {
          sb.append('*');
        }
      }
      if (degree == -1) {
        sb.append("-x");
      } else if (degree == 1) {
        sb.append("x");
      } else if (degree == 0) {

      } else {
        sb.append("x^" + degree);
      }
      return sb.toString();
    }
  }

  public static class Polynomial {

    private Map<Integer, Integer> polynomialMap;

    private Polynomial() {
      polynomialMap = new HashMap<>();
    }

    public Polynomial(PolynomialMember[] members) {
      this();
      for (PolynomialMember m : members) {
        addMember(m);
      }
    }


    public Polynomial derivative() {
      Polynomial polynomial = new Polynomial();
      for (PolynomialMember member : getMembers()) {
        polynomial.addMember(member.degree * member.coef, member.degree - 1);
      }
      return polynomial;
    }

    public PolynomialMember[] getMembers() {
      return polynomialMap.entrySet().stream()
          .map(entry -> new PolynomialMember(entry.getValue(), entry.getKey()))
          .toArray(PolynomialMember[]::new);
    }

    public void addMember(int coef, int degree) {
      if (coef != 0) {
        if (polynomialMap.containsKey(degree)) {
          int currentCoef = polynomialMap.get(degree);
          polynomialMap.put(degree, currentCoef + coef);
        } else {
          polynomialMap.put(degree, coef);
        }
      }
    }

    public void addMember(PolynomialMember member) {
      addMember(member.coef, member.degree);
    }

    public static Polynomial parse(String s) {
      return PolynomialParser.parse(s);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Polynomial that = (Polynomial) o;

      return polynomialMap.equals(that.polynomialMap);
    }

    @Override
    public int hashCode() {
      return polynomialMap.hashCode();
    }

    @Override
    public String toString() {
      List<Integer> coef = new ArrayList<>(polynomialMap.keySet());
      Collections.sort(coef);
      Collections.reverse(coef);

      String result = coef.stream().map(
          degree -> new PolynomialMember(polynomialMap.get(degree), degree))
          .map(member -> {
            if (member.coef > 0) {
              return "+" + member.toString();
            }
            return member.toString();
          })
          .collect(Collectors.joining(""));
      if (result.startsWith("+")) {
        return result.substring(1);
      }
      return result;
    }
  }


  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      System.out.println(Polynomial.parse(reader.readLine()).derivative());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }


  private static class PolynomialParser {

    enum State {
      COEF, DEGREE, START, ERR
    }

    public static Polynomial parse(String s) {
      State state = State.START;
      StringBuilder coefBuilder = new StringBuilder();
      StringBuilder degreeBuilder = new StringBuilder();
      Polynomial polynomial = new Polynomial();
      for (int i = 0; i < s.length(); i++) {
        Character c = s.charAt(i);
        switch (state) {
          case START:
            if (Character.isDigit(c) || c.equals('-')) {
              state = State.COEF;
              coefBuilder.append(c);
            } else if (c.equals('+')) {
              state = State.COEF;
            } else if (c.equals('x')) {
              state = State.DEGREE;
            } else {
              state = State.ERR;
            }
            break;
          case ERR:
            throw new IllegalStateException();
          case COEF:
            if (Character.isDigit(c)) {
              coefBuilder.append(c);
            } else if (c.equals('+') || c.equals('-')) {
              polynomial.addMember(parseNumber(coefBuilder), 0);
              coefBuilder.setLength(0);
              state = State.COEF;
            } else if (c.equals('*') || c.equals('x')) {
              state = State.DEGREE;
            } else {
              state = State.ERR;
            }
            break;
          case DEGREE:
            if (Character.isDigit(c)) {
              degreeBuilder.append(c);
            } else if (c.equals('^')) {
              state = State.DEGREE;
            } else if (c.equals('x')) {
              state = State.DEGREE;
            } else if (c.equals('+') || c.equals('-')) {
              state = State.COEF;
              polynomial.addMember(parseMember(coefBuilder, degreeBuilder));
              coefBuilder.setLength(0);
              degreeBuilder.setLength(0);
              if (c.equals('-')) {
                coefBuilder.append('-');
              }
            } else {
              state = State.ERR;
            }
            break;
          default:
            state = State.ERR;
        }

        if (i == s.length() - 1) {
          if (state.equals(State.DEGREE)) {
            polynomial.addMember(parseMember(coefBuilder, degreeBuilder));
          } else if (state.equals(State.COEF)) {
            polynomial.addMember(parseNumber(coefBuilder), 0);
          } else {
            throw new IllegalStateException();
          }
          coefBuilder.setLength(0);
          degreeBuilder.setLength(0);
        }
      }
      return polynomial;
    }


    private static PolynomialMember parseMember(StringBuilder coefBuilder,
        StringBuilder degreeBuilder) {
      return new PolynomialMember(parseNumber(coefBuilder),
          parseNumber(degreeBuilder));
    }

    private static int parseNumber(StringBuilder coefBuilder) {
      if (coefBuilder.length() == 0 || "-".equals(coefBuilder.toString())) {
        coefBuilder.append('1');
      }
      return Integer.parseInt(coefBuilder.toString());
    }
  }
}
