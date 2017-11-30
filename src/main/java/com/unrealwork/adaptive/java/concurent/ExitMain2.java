package com.unrealwork.adaptive.java.concurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExitMain2 {

  private static final int POOL_SIZE = 50;

  public static void main(final String[] args) throws Exception {
    final ExecutorService executor = Executors
        .newFixedThreadPool(POOL_SIZE, runnable -> {
          final Thread thread = new Thread(runnable);
          thread.setDaemon(true);
          return thread;
        });
    for (int i = 0; i < POOL_SIZE; i++) {
      executor.submit(() -> System.out
          .printf("Running %s%n", Thread.currentThread().getName()));
    }
  }
}
