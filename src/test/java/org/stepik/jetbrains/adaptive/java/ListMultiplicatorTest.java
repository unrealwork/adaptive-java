package org.stepik.jetbrains.adaptive.java;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.stepik.jetbrains.adaptive.java.collections.ListMultiplicator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ListMultiplicatorTest {

  @Test(dataProvider = "multiplyListDataProvider")
  public void testMultiply(List<?> list, int n, List<?> expectedList)
      throws Exception {
    ListMultiplicator.multiply(list, n);
    assertEquals(list, expectedList);
  }


  @DataProvider(name = "multiplyListDataProvider")
  private Object[][] provideListMultiplyData() {
    return new Object[][]{
        {new ArrayList<Integer>(Arrays.asList(1, 2)), 2,
            Arrays.asList(1, 2, 1, 2)}
    };
  }
}