package com.mershab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClosedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldVal = this.value;
            this.value = value;
            return oldVal;
        }
    }

    List<ArrayList<Entry<K, V>>> dataStore;

    final int DEFAULT_INITIAL_CAPACITY = 20;
    final int CAPACITY;

    public ClosedHashMap(int initialCapacity) {
        super(initialCapacity);
        init(initialCapacity);
        CAPACITY = initialCapacity;
    }

    public ClosedHashMap() {
        init(DEFAULT_INITIAL_CAPACITY);
        CAPACITY = DEFAULT_INITIAL_CAPACITY;
    }

    private void init(int initialCapacity) {
        dataStore = IntStream.range(0, initialCapacity)
                .mapToObj(i -> new ArrayList<Entry<K, V>>())
                .collect(Collectors.toList());
    }

    @Override
    public int size() {
        return dataStore.stream()
                .mapToInt(List::size)
                .sum();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = indexOf(key.hashCode());
        ArrayList<Entry<K, V>> bucket = dataStore.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (ArrayList<Entry<K, V>> bucket : dataStore) {
            for (Entry<K, V> entry : bucket) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int bucketIndex = indexOf(key.hashCode());
        ArrayList<Entry<K, V>> bucket = dataStore.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = indexOf(key.hashCode());
        ArrayList<Entry<K, V>> bucket = dataStore.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                var oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        bucket.add(new Entry<>(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        int bucketIndex = indexOf(key.hashCode());
        ArrayList<Entry<K, V>> bucket = dataStore.get(bucketIndex);


        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        for (ArrayList<Entry<K, V>> bucket : dataStore) {
            bucket.clear();
        }

    }

    @Override
    public Set<K> keySet() {
        return dataStore.stream()
                .flatMap(List::stream)
                .map(entry -> entry.key)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<V> values() {
        return dataStore.stream()
                .flatMap(List::stream)
                .map(entry -> entry.value)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return dataStore.stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    private int indexOf(int hashCode) {
        return Math.abs(hashCode % CAPACITY);
    }
}
