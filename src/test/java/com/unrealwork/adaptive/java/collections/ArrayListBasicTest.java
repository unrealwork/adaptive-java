package com.unrealwork.adaptive.java.collections;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayListBasicTest {

  @DataProvider
  public static Object[][] listsProvider() {
    return new Object[][]{
        {Arrays.asList(847, 271, 663, 473, 376, 133, 693, 13, 382, 879), 879}
    };
  }

  @Test(dataProvider = "listsProvider")
  public void testMaxElem(List<Integer> list, Integer max) {
    Assert.assertEquals(ArrayListBasic.maxElem(list), max);
  }
}