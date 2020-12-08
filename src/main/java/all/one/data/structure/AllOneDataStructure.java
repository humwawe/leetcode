package all.one.data.structure;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class AllOneDataStructure {
    Bucket head;
    Bucket tail;
    Map<String, Integer> map1;
    Map<Integer, Bucket> map2;

    public AllOneDataStructure() {
        head = new Bucket();
        tail = new Bucket();
        head.next = tail;
        tail.pre = head;
        map2 = new HashMap<>();
        map1 = new HashMap<>();
    }


    public void inc(String key) {
        if (map1.containsKey(key)) {
            int count = map1.get(key);
            Bucket cur = map2.get(count);
            Bucket next = map2.get(count + 1);
            if (next == null) {
                Bucket newBucket = new Bucket();
                newBucket.keySet.add(key);
                addBucketAfter(newBucket, cur);
                map2.put(count + 1, newBucket);
            } else {
                map2.get(count + 1).keySet.add(key);
            }
            map1.put(key, count + 1);
            removeKeyFromBucket(cur, key, count);
        } else {
            map1.put(key, 1);
            if (map2.containsKey(1)) {
                map2.get(1).keySet.add(key);
            } else {
                Bucket newBucket = new Bucket();
                addBucketAfter(newBucket, head);
                newBucket.keySet.add(key);
                map2.put(1, head.next);
            }
        }
    }

    public void dec(String key) {
        if (map1.containsKey(key)) {
            int count = map1.get(key);
            Bucket cur = map2.get(count);
            Bucket prev = map2.get(count - 1);
            if (count == 1) {
                map1.remove(key);
            } else {
                if (prev != null) {
                    prev.keySet.add(key);
                } else {
                    prev = new Bucket();
                    prev.keySet.add(key);
                    addBucketAfter(prev, cur.pre);
                    map2.put(count - 1, prev);
                }
                map1.put(key, count - 1);
            }
            removeKeyFromBucket(cur, key, count);
        }
    }


    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void removeKeyFromBucket(Bucket bucket, String key, int count) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            map2.remove(count);
        }
    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.pre.next = bucket.next;
        bucket.next.pre = bucket.pre;
        bucket.next = null;
        bucket.pre = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.pre = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
    }

    private class Bucket {
        Set<String> keySet;
        Bucket next;
        Bucket pre;

        public Bucket() {
            keySet = new HashSet<>();
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    " keySet=" + keySet +
                    '}';
        }
    }


}
