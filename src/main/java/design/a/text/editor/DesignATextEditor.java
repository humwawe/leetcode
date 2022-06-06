package design.a.text.editor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class DesignATextEditor {
  Deque<Character> left;
  Deque<Character> right;

  public DesignATextEditor() {
    left = new ArrayDeque<>();
    right = new ArrayDeque<>();
  }

  public void addText(String text) {
    for (char c : text.toCharArray()) {
      left.add(c);
    }
  }

  public int deleteText(int k) {
    int ret = Math.min(left.size(), k);
    for (int i = 0; i < ret; i++) {
      left.pollLast();
    }
    return ret;
  }

  public String cursorLeft(int k) {
    int o = Math.min(left.size(), k);
    for (int i = 0; i < o; i++) {
      char c = left.pollLast();
      right.addFirst(c);
    }
    int q = Math.min(10, left.size());
    char[] ret = new char[q];
    for (int i = q - 1; i >= 0; i--) {
      ret[i] = left.pollLast();
    }

    for (int i = 0; i < q; i++) {
      left.addLast(ret[i]);
    }

    return new String(ret);
  }

  public String cursorRight(int k) {
    int o = Math.min(right.size(), k);
    for (int i = 0; i < o; i++) {
      char c = right.pollFirst();
      left.addLast(c);
    }
    int q = Math.min(10, left.size());
    char[] ret = new char[q];
    for (int i = q - 1; i >= 0; i--) {
      ret[i] = left.pollLast();
    }
    for (int i = 0; i < q; i++) {
      left.addLast(ret[i]);
    }
    return new String(ret);
  }
}
