package com.mershab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClosedHashMapTest {


    private ClosedHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new ClosedHashMap<>();
    }

    // --- Basic Map Operations ---

    @Test
    void testPutAndGet() {
        map.put("key1", 1);
        assertEquals(1, map.get("key1"));
    }

    @Test
    void testPutOverwrite() {
        map.put("key1", 1);
        map.put("key1", 2);
        assertEquals(2, map.get("key1"));
    }

    @Test
    void testRemove() {
        map.put("key1", 1);
        map.remove("key1");
        assertNull(map.get("key1"));
    }

    @Test
    void testContainsKey() {
        map.put("key1", 1);
        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key2"));
    }

    @Test
    void testContainsValue() {
        map.put("key1", 1);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(2));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(map.isEmpty());
        map.put("a", 10);
        assertEquals(1, map.size());
        map.remove("a");
        assertTrue(map.isEmpty());
    }

    @Test
    void testClear() {
        map.put("x", 100);
        map.put("y", 200);
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    void testKeySet() {
        map.put("a", 1);
        map.put("b", 2);
        Set<String> keys = map.keySet();
        assertEquals(2, keys.size());
        assertTrue(keys.contains("a"));
        assertTrue(keys.contains("b"));
    }

    @Test
    void testValues() {
        map.put("a", 1);
        map.put("b", 2);
        Collection<Integer> values = map.values();
        assertEquals(2, values.size());
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    void testEntrySet() {
        map.put("a", 1);
        map.put("b", 2);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(2, entries.size());
    }

    // --- Extended/Custom Behavior ---

    @Test
    void testCustomBehaviorIfAny() {
        // If ClosedHashMap overrides or introduces new methods, test them here.
        // Example:
        // assertTrue(map.isClosedAddressing());
    }


    @Test
    void testBulkPutAll() {
        Map<String, Integer> other = Map.of("x", 9, "y", 8);
        map.putAll(other);
        assertEquals(2, map.size());
        assertEquals(9, map.get("x"));
    }

}
