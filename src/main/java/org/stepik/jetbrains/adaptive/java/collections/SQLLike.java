package org.stepik.jetbrains.adaptive.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SQLLike {

  public static void task() {
    List<Transaction> transactions = new ArrayList<>();
    Function<Transaction, String> keyMapper = t -> t.getAccount().getLogin();
    Map<String, Long> totalSumOfTransByEachAccount =
        transactions.stream()
            .collect(Collectors.groupingBy(t -> t.getAccount().getLogin(),
                Collectors.summingLong(Transaction::getSum)));
  }

  public static void task2() {
    List<LogEntry> logs = Collections.emptyList();
    Function<LogEntry, String> f = LogEntry::getUrl;
    Map<String, Long> clickCount =
        logs.stream()
            .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
  }

  private static class Transaction {

    private String uuid;
    private Integer sum;
    private Account account;

    private Transaction(String uuid, Integer sum, Account account) {
      this.uuid = uuid;
      this.sum = sum;
      this.account = account;
    }

    public Account getAccount() {
      return account;
    }

    public Integer getSum() {
      return sum;
    }
  }

  private static class Account {

    private String login;

    private Account(String login) {
      this.login = login;
    }

    public String getLogin() {
      return login;
    }
  }

  private static class LogEntry {
    private Date created;
    private String login;
    private String url;

    private LogEntry(Date created, String login, String url) {
      this.created = created;
      this.login = login;
      this.url = url;
    }

    public String getUrl() {
      return url;
    }

    public String getLogin() {
      return login;
    }

    public Date getCreated() {
      return created;
    }
  }
}
