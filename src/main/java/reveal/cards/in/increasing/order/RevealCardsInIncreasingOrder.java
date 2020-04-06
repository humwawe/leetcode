package reveal.cards.in.increasing.order;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author hum
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            Integer integer = list.peekLast();
            if (integer != null) {
                list.addFirst(list.removeLast());
            }
            list.addFirst(deck[i]);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
