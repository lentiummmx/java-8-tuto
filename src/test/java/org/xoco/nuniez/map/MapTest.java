package org.xoco.nuniez.map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapTest {
    static Map<Integer, String> map;

    @BeforeClass
    public static void setUp() throws Exception {
        map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
    }

    @Test
    public void forEachTest() {
        map.forEach((id, val) -> System.out.println(val));
    }

    @Test
    public void computeTest() {
        map.computeIfPresent(3, (key, val) -> val + key);
        assertEquals("val33", map.get(3));

        map.computeIfPresent(9, (key, val) -> null);
        assertFalse(map.containsKey(9));

        map.computeIfAbsent(23, key -> "val" + key);
        assertTrue(map.containsKey(23));

        map.computeIfAbsent(3, key -> "bam");
        assertEquals("val33", map.get(3));
    }

    @Test
    public void removeTest() {
        map.remove(3, "val3");
        assertEquals("val33", map.get(3));

        map.remove(3, "val33");
        assertNull(map.get(3));;
    }

    @Test
    public void getOrDefaultTest() {
        assertEquals("not found", map.getOrDefault(42, "not found"));
    }

    @Test
    public void mergeTest() {
        map.merge(9, "val9", (val, newVal) -> val.concat(newVal));
        assertEquals("val9", map.get(9));

        map.merge(9, "concat", (val, newVal) -> val.concat(newVal));
        assertEquals("val9concat", map.get(9));
    }
}
