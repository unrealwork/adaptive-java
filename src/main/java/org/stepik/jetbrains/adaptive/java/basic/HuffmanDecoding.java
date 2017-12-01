package org.stepik.jetbrains.adaptive.java.basic;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class HuffmanDecoding {

  private static class HuffmanDecoder {

    private static HuffmanDecoder decoder;
    private final Map<String, Character> codes;

    private HuffmanDecoder(Map<String, Character> codes) {
      this.codes = codes;
    }

    public static HuffmanDecoder of(Map<String, Character> codes) {
      if (decoder == null) {
        decoder = new HuffmanDecoder(codes);
      }
      return decoder;
    }

    public String decode(String s) {
      final StringBuilder sb = new StringBuilder();
      final StringBuilder tokenBuilder = new StringBuilder();
      int i = 0;
      int a = 3;
      Function<Integer, Integer> f = (x) -> a * x;
      s.chars().mapToObj(n -> ((char) n))
          .forEach(c -> {
            tokenBuilder.append(c);
            if (codes.containsKey(tokenBuilder.toString())) {
              sb.append(codes.get(tokenBuilder.toString()));
              tokenBuilder.setLength(0);
            }
          });
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int symbolsCount = in.nextInt();
    in.nextLine();

    Map<String, Character> codes = IntStream.range(0, symbolsCount)
        .mapToObj(i -> in.nextLine()).collect(Collectors.toMap(
            s -> s.split(":")[1].trim(),
            s -> s.split(":")[0].charAt(0)
        ));

    final String decoded = HuffmanDecoder.of(codes).decode(in.nextLine());

    System.out.println(decoded);

    in.close();
  }
}
