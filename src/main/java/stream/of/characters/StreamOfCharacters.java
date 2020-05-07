package stream.of.characters;

/**
 * @author hum
 */
public class StreamOfCharacters {
    Node root;
    StringBuilder stringBuilder = new StringBuilder();

    public StreamOfCharacters(String[] words) {
        root = new Node();
        for (String word : words) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.child[c] == null) {
                    cur.child[c] = new Node();
                }
                cur = cur.child[c];
            }
            cur.end = true;
        }
    }

    public boolean query(char letter) {
        stringBuilder.insert(0, letter);
        if (stringBuilder.length() > 2000) {
            stringBuilder.delete(2000, stringBuilder.length());
        }
        Node cur = root;
        for (int i = 0; i < stringBuilder.length(); i++) {
            int c = stringBuilder.charAt(i) - 'a';
            if (cur.child[c] == null) {
                return false;
            }
            cur = cur.child[c];
            if (cur.end) {
                return true;
            }
        }
        return false;
    }

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }
}
