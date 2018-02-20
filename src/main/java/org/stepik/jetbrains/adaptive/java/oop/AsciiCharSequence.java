package org.stepik.jetbrains.adaptive.java.oop;

public class AsciiCharSequence implements CharSequence {

  private byte[] storage;

  public AsciiCharSequence(byte[] storage) {
    this.storage = storage;
  }

  @Override
  public int length() {
    return storage.length;
  }

  @Override
  public char charAt(int index) {
    return (char) storage[index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    int newLength = end - start;
    byte[] newStorage = new byte[newLength];
    for (int i = start; i < end; i++) {
      newStorage[i - start] = storage[i];
    }
    return new AsciiCharSequence(newStorage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < storage.length; i++) {
      sb.append(charAt(i));
    }
    return sb.toString();
  }
}
