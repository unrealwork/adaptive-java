package com.unrealwork.adaptive.java;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PrimeCheckerTest {

  @Test(dataProvider = "primeDataProvider")
  public void testIsPrime(Long number, boolean expecedResult) throws Exception {
    assertEquals(PrimeChecker.isPrime(number), expecedResult);
  }

  @DataProvider(name = "primeDataProvider")
  private Object[][] providePrimeData() {
    return new Object[][]{
        {37L, true},
        {6L, false}
    };
  }
}