package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Scanner;

public class DigitalWatches {

  public static class Watches {

    private static final int HOUR_SEC = 3600;
    private static final int MINUTES_SEC = 60;
    private int hours;
    private int minutes;
    private int seconds;

    private Watches(final int ms) {
      this.hours = (ms / HOUR_SEC) % 24;
      int restMs = ms % HOUR_SEC;
      this.minutes = restMs / MINUTES_SEC;
      this.seconds = restMs % MINUTES_SEC;
    }

    public static Watches of(final int ms) {
      return new Watches(ms);
    }

    @Override
    public String toString() {
      return String.format("%s:%s:%s",
          toString(hours, false),
          toString(minutes, true),
          toString(seconds, true)
      );
    }

    private String toString(final int nums, boolean isLeading) {
      if (isLeading && nums < 10) {
        return "0" + nums;
      }
      return Integer.toString(nums);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(Watches.of(in.nextInt()));
    in.close();
  }
}
