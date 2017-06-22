package com.unrealwork.adaptive.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shmagrinsky on 22.06.2017.
 */
public class ArrayConverter {

  public static void main(String[] args) {

    List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

    String[] strArray = new String[nameList.size()];
    //write your code here
    nameList.toArray(strArray);

    for (int i = 0; i < strArray.length; i++) {
      System.out.println(strArray[i]);
    }

  }
}
