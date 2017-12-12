package org.stepik.jetbrains.adaptive.java.basic;

class LocalInit {
  public static void main(String[] args) {
    String s = getStr(42);
    System.out.println(s);
  }

  private static String getStr(int e) {
    String s;
    switch (e) {
      case 42:
        s = "42";
      default:
      case 12:
        s = "11";
        break;
    }
    return s;
  }
}
