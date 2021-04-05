package sentence.similarity.III;

/**
 * @author hum
 */
public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        String[] a = sentence1.split(" ");
        String[] b = sentence2.split(" ");
        int i = 0;
        int j = a.length - 1;
        for (int k = 0; k < b.length && i < a.length; k++) {
            if (a[i].equals(b[k])) {
                i++;
            } else {
                break;
            }
        }
        for (int k = b.length - 1; k >= 0 && j >= 0; k--) {
            if (a[j].equals(b[k])) {
                j--;
            } else {
                break;
            }
        }
        return i > j;
    }
}
