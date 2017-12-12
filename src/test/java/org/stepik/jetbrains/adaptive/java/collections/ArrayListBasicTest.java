package org.stepik.jetbrains.adaptive.java.collections;

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

  @DataProvider
  public static Object[][] stringLists() {
    return new Object[][]{
        {Arrays.asList("hi", "hello", "goodmorning", "ass"),
            Arrays.asList("goodmorning", "goodmorning", "goodmorning",
                "goodmorning")}
    };
  }

  @Test(dataProvider = "listsProvider")
  public void testMaxElem(final List<Integer> list, final Integer max) {
    Assert.assertEquals(ArrayListBasic.maxElem(list), max);
  }

  @Test(dataProvider = "stringLists")
  public void testChangeList(final List<String> list,
      final List<String> expectedChanged) {
    Assert.assertEquals(ArrayListBasic.changeList(list),expectedChanged);
  }
}