package org.stepik.jetbrains.adaptive.java;


import org.stepik.jetbrains.adaptive.java.basic.DerivativePolynomial.Polynomial;
import org.stepik.jetbrains.adaptive.java.basic.DerivativePolynomial.PolynomialMember;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DerivativePolynomialTest {

  @DataProvider
  public static Object[][] parsePolynomialProvider() {
    return new Object[][]{
        {
            "x^2+x",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(1, 2),
                PolynomialMember.member(1, 1)
            })
        },
        {
            "2*x+1",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(2, 1),
                PolynomialMember.member(1, 0)
            })
        },
        {
            "x+x+x+x+x+x+x+x+x+x",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(10, 1)})
        },
        {
            "-3*x^2-2*x",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(-3, 2),
                PolynomialMember.member(-2, 1)
            })
        },
        {
            "-x^2-x^3",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(-1, 2),
                PolynomialMember.member(-1, 3)
            })
        },
        {
            "10000*x^9999+1",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(10000, 9999),
                PolynomialMember.member(1, 0)
            })
        },
        {
            "200*x^99+200*x",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(200, 99),
                PolynomialMember.member(200, 1)
            })
        },
        {
            "2*x+6",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(2, 1),
                PolynomialMember.member(6, 0)
            })
        },
        {
            "2*x-6",
            new Polynomial(new PolynomialMember[]{
                PolynomialMember.member(2, 1),
                PolynomialMember.member(-6, 0)
            })
        }
    };
  }

  @DataProvider
  public static Object[][] derivativeProvider() {
    return new Object[][]{
        {"x^2+x", "2*x+1"},
        {"2*x^100+100*x^2", "200*x^99+200*x"},
        {"x^10000+x+1", "10000*x^9999+1"},
        {"-x^2-x^3", "-3*x^2-2*x"},
        {"x+x+x+x+x+x+x+x+x+x", "10"}
    };
  }

  @Test(dataProvider = "derivativeProvider")
  public void testDerivative(String polynomialString,
      String expectedDerivativePolynomial) {
    Assert.assertEquals(
        Polynomial.parse(polynomialString).derivative().toString(),
        expectedDerivativePolynomial);
  }

  @Test(dataProvider = "parsePolynomialProvider")
  public void testPolynomialParse(String s, Polynomial expectedPolynomial) {
    Assert.assertEquals(Polynomial.parse(s), expectedPolynomial);
  }
}
