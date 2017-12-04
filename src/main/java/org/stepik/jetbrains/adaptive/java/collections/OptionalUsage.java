package org.stepik.jetbrains.adaptive.java.collections;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OptionalUsage {

  private static final Set<User> users = new HashSet<>();

  public static Optional<User> findUserByLogin(String login) {
    return users.stream().filter(u -> u.getLogin().equals(login)).findAny();
  }

  public static void printBalanceIfNotEmpty(String userLogin) {
    findUserByLogin(userLogin)
        .map(User::getAccount)
        .map(Account::getBalance)
        .filter(b -> b > 0).ifPresent(
        b -> System.out.printf("%s: %s", userLogin, b)
    );
  }

  public static void main(String[] args) {

  }

  private static class User {

    private Account account;
    private String login;

    private User(Account account, String login) {
      this.account = account;
      this.login = login;
    }

    public String getLogin() {
      return login;
    }

    public Account getAccount() {
      return account;
    }
  }

  private class Account {

    private double balance;

    public double getBalance() {
      return balance;
    }
  }
}
