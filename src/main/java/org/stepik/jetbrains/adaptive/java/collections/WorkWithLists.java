package org.stepik.jetbrains.adaptive.java.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkWithLists {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    String allElements = reader.readLine();
    List<Integer> bigList = createBigList(allElements);

    ArrayList<Integer> div2list = filteredArrayList(bigList, n -> n % 2 == 0);
    ArrayList<Integer> div3list = filteredArrayList(bigList, n -> n % 3 == 0);
    ArrayList<Integer> otherlist = filteredArrayList(bigList,
        n -> n % 2 != 0 && n % 3 != 0);

    //add the necessary elements from bigList to div2list,div3list,otherlist and sort all three lists

    //get result list from createListOfLists
    List<List<Integer>> resultList = createListOfLists(div2list, div3list,
        otherlist);

    //call printInLine() for resultList
    printInLine(resultList);
  }

  private static void printInLine(List<List<Integer>> resultList) {
    resultList.forEach(list -> {
          System.out.println(list.stream().map(Object::toString).
              collect(Collectors.joining(" ", "", ";")));
        }
    );
  }

  private static ArrayList<Integer> filteredArrayList(List<Integer> bigList,
      java.util.function.Predicate<Integer> predicate) {
    return bigList.stream().filter(predicate).sorted()
        .collect(
            Collectors.toCollection(ArrayList::new));
  }

  public static List<Integer> createBigList(String str) {
    List<Integer> bigList = new ArrayList<Integer>();
    String[] strarr = str.split(" ");

    for (String s : strarr) {
      bigList.add(Integer.parseInt(s));
    }
    return bigList;
  }

  public static List<List<Integer>> createListOfLists(List<Integer> div2list,
      List<Integer> div3list, List<Integer> otherList) {
    List<List<Integer>> resultList = new ArrayList<>();
    resultList.add(div2list);
    resultList.add(div3list);
    resultList.add(otherList);
    //add all lists like items in resultList(list of lists) and return it, first-div2list, second-div3list, third-otherList
    return resultList;
  }
}
