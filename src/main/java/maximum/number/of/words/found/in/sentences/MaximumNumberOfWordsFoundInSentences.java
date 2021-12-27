package maximum.number.of.words.found.in.sentences;

/**
 * @author hum
 */
public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            res = Math.max(res, sentence.split(" ").length);
        }
        return res;
    }
}
