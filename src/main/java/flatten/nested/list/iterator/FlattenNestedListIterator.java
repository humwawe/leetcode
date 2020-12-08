package flatten.nested.list.iterator;

import common.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hum
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        helper(nestedList);
        index = 0;
    }

    private void helper(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return;
        }
        for (NestedInteger nestedInteger : nestedList) {
            System.out.println(list);
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                helper(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
