package redistribute.characters.to.make.all.strings.equal;

/**
 * @author hum
 */
public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int len = words.length;
        int[] cnt = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
        }
        for (int i : cnt) {
            if (i % len != 0) {
                return false;
            }
        }
        return true;
    }
}
