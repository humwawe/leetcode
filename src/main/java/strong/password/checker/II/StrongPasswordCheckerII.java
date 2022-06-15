package strong.password.checker.II;

/**
 * @author hum
 */
public class StrongPasswordCheckerII {
  public boolean strongPasswordCheckerII(String password) {
    if (password.length() < 8) {
      return false;
    }
    String t = "!@#$%^&*()-+";
    int x = 0;
    for (char c : password.toCharArray()) {
      if ('a' <= c && c <= 'z') {
        x |= 1;
      } else if ('A' <= c && c <= 'Z') {
        x |= 1 << 1;
      } else if (Character.isDigit(c)) {
        x |= 1 << 2;
      } else if (t.contains("" + c)) {
        x |= 1 << 3;
      }
    }
    if (x != 15) {
      return false;
    }
    for (int i = 1; i < password.length(); i++) {
      if (password.charAt(i) == password.charAt(i - 1)) {
        return false;
      }
    }
    return true;
  }
}
