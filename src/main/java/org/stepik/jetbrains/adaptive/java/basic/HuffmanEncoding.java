package org.stepik.jetbrains.adaptive.java.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class HuffmanEncoding {

  private static class Node implements Comparable<Node> {

    private final Character key;
    private Integer value;
    private Node left;
    private Node right;

    public Node(Character character, Integer key) {
      this.key = character;
      this.value = key;
    }

    private Node(int frequency,
        Node left,
        Node right) {
      this.left = left;
      this.right = right;
      this.key = null;
      this.value = frequency;
    }

    @Override
    public int compareTo(Node that) {
      int res = Integer.compare(value, that.value);
      if (res == 0) {
        if (key == null && that.key == null) {
          return 0;
        } else {
          if (that.key == null) {
            return -1;
          } else if (key == null) {
            return 1;
          } else {
            return Integer.compare(key, that.key);
          }
        }
      }
      return res;
    }
  }


  public static class HuffmanEncoder {

    private String encodingString;
    private Map<Character, Integer> frequencyMap;
    private Node tree;
    private Map<Character, String> dict;

    public HuffmanEncoder(String encodingString) {
      this.encodingString = encodingString;
    }

    public Map<Character, String> dict() {
      if (dict == null) {
        dict = new HashMap<>();
        Node tree = buildTree();
        if (tree.key != null) {
          dict.put(tree.key, "0");
        } else {
          dict(tree, "", dict);
        }
      }
      return this.dict;
    }

    private void dict(Node tree, String s, Map<Character, String> dict) {
      if (tree.key != null) {
        dict.put(tree.key, s);
      } else {
        dict(tree.left, s + "1", dict);
        dict(tree.right, s + "0", dict);
      }
    }

    private Node buildTree() {
      if (this.tree == null) {
        final Set<Node> symbolNodes = frequencyMap().entrySet()
            .stream()
            .map(e -> new Node(e.getKey(), e.getValue()))
            .collect(Collectors.toSet());

        PriorityQueue<Node> heap = new PriorityQueue<>(symbolNodes);
        while (heap.size() > 1) {
          Node right = heap.poll();
          Node left = heap.poll();
          heap.add(new Node(right.value + left.value, left, right));
        }
        this.tree = heap.peek();
      }
      return this.tree;
    }

    public Map<Character, Integer> frequencyMap() {
      if (this.frequencyMap == null) {
        frequencyMap = new HashMap<>();
        for (int i = 0; i < encodingString.length(); i++) {
          final char c = encodingString.charAt(i);
          if (frequencyMap.containsKey(c)) {
            frequencyMap.put(c, frequencyMap.get(c) + 1);
          } else {
            frequencyMap.put(c, 1);
          }
        }
      }
      return frequencyMap;
    }

    public String encode() {
      final Map<Character, String> codes = dict();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < encodingString.length(); i++) {
        final char c = encodingString.charAt(i);
        sb.append(codes.get(c));
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in))) {
      HuffmanEncoder encoder = new HuffmanEncoder(reader.readLine());
      Map<Character, String> dict = encoder.dict();
      final int size = dict.size();
      final String codedString = encoder.encode();
      System.out.println(String.format("%d %d", size, codedString.length()));
      dict.forEach(
          (c, code) -> System.out.println(String.format("%c: %s", c, code)));
      System.out.println(codedString);
    } catch (
        IOException e)

    {
      throw new IllegalStateException();
    }
  }
}
