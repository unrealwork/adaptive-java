package org.stepik.csc.algorithms.divcon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTest {

  @Test
  public void testBinarySearch() {
    Assert.assertEquals(BinarySearch.find(new Integer[]{1, 2, 3}, 3), 3);
    Assert.assertEquals(BinarySearch.find(new Integer[]{1, 5, 8, 12, 13}, 8), 3);
  }
}