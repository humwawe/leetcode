package encrypt.and.decrypt.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class EncryptAndDecryptStrings {

  Map<Character, String> map = new HashMap<>();
  Map<String, Integer> map2 = new HashMap<>();

  public EncryptAndDecryptStrings(char[] keys, String[] values, String[] dictionary) {
    for (int i = 0; i < keys.length; i++) {
      map.put(keys[i], values[i]);
    }
    for (String s : dictionary) {
      String encrypt = encrypt(s);
      if ("".equals(encrypt)) {
        continue;
      }
      map2.put(encrypt, map2.getOrDefault(encrypt, 0) + 1);
    }

  }

  public String encrypt(String word1) {
    StringBuilder res = new StringBuilder();
    for (char c : word1.toCharArray()) {
      if (!map.containsKey(c)) {
        return "";
      }
      res.append(map.get(c));
    }
    return res.toString();
  }

  public int decrypt(String word2) {
    return map2.getOrDefault(word2, 0);
  }
}
