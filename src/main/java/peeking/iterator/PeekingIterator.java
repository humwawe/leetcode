package peeking.iterator;

import java.util.Iterator;

/**
 * @author hum
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    private Integer cache = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        }
        Integer temp = cache;
        cache = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}
