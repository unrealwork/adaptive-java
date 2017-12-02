package org.stepik.csc.algorithms.divcon;

import java.util.Arrays;
import java.util.List;
import org.stepik.csc.algorithms.divcon.SegmentCount.Segment;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SegmentCountTest {

  @DataProvider
  private static Object[][] segmentsCountProvider() {
    Integer[] points = {1, 2, 4, 5, 7};
    return new Object[][]{
        //Start cases
        {points, 5, true, 3},
        {points, 1, true, 0},
        {points, 7, true, 4},
        {points, 8, true, 5},
        {points, 6, true, 4},
        {points, 3, true, 2},
        //End cases
        {points, 3, false, 2},
        {points, 1, false, 1},
        {points, 7, false, 5}
    };
  }

  @DataProvider
  public static Object[][] solutionProvider() {
    return new Object[][]{
        {
            segments(new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {3, 4},
                {3, 5},
                {3, 6}
            }),
            new int[]{1, 2, 3, 4, 5, 6},
            Arrays.asList(2, 3, 6, 3, 2, 1)
        },

    };
  }

  private static Segment[] segments(int[][] ints) {
    return Arrays.stream(ints).map(arr -> new Segment(arr[0], arr[1]))
        .toArray(Segment[]::new);
  }

  @Test(dataProvider = "segmentsCountProvider")
  public void testFind(Integer[] points, int bound, Boolean isLess,
      int expectedResult) {
    int actualResult = SegmentCount.count(points, bound, isLess);
    Assert.assertEquals(actualResult, expectedResult);
  }

  @Test(dataProvider = "solutionProvider")
  public void testSolve(Segment[] segments, int[] points,
      List<Integer> result) {
    Assert.assertEquals(SegmentCount.solve(segments, points), result);
  }
}