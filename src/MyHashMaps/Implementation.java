package MyHashMaps;

import java.util.*;

public class Implementation {
    static class MyHashMap<K, V> {
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private LinkedList<Node>[] buckets;
        private int n;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        private void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return (Math.abs(hc)) % buckets.length;
        }

        private int searchInBucket(LinkedList<Node> list, K key) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        MyHashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        public int size() {
            return n;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if (ei == -1) {
                Node newNode = new Node(key, value);
                currBucket.add(newNode);
                n++;
            } else {
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> buck = buckets[bi];
            int ei = searchInBucket(buck, key);
            if (ei == -1) {
                return null;
            } else {
                return buck.get(ei).value;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> buck = buckets[bi];
            int ei = searchInBucket(buck, key);
            if (ei == -1) {
                return null;
            } else {
                Node currNode = buck.get(ei);
                V val = currNode.value;
                buck.remove(ei);
                n--;
                return val;
            }
        }

    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> mp = new MyHashMap<>();
        mp.put(1, 10);
        mp.put(2, 20);
        mp.put(3, 30);
        mp.put(2, 40);
        mp.remove(3);
        System.out.println(mp.size());
    }
}