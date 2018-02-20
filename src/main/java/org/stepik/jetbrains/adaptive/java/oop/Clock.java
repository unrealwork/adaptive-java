package org.stepik.jetbrains.adaptive.java.oop;

class Clock {

  int hours = 12;
  int minutes = 0;

  // write a method here
  void next() {
    minutes++;
    if (minutes > 59) {
      hours++;
      minutes %= 60;
    }
    if (hours > 12) {
      hours %= 12;
    }
  }
}