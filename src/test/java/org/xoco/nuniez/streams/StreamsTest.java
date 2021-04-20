package org.xoco.nuniez.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class StreamsTest {
     List<String> stringCollection;

    @Before
    public void setUp() throws Exception {
        stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    @Test
    public void filterTest() {
        stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
        // assertEquals(Arrays.asList("aaa2", "aaa1"), );
    }

    @Test
    public void sortedTest() {
        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void mapTest() {
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    @Test
    public void matchTest() {
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println("anyStartsWithA :: " + anyStartsWithA);
        assertTrue(anyStartsWithA);

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println("allStartsWithA :: " + allStartsWithA);
        assertFalse(allStartsWithA);

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println("noneStartsWithZ :: " + noneStartsWithZ);
        assertTrue(noneStartsWithZ);
    }

    @Test
    public void countTest() {
        long startsWithB = stringCollection
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();
        assertEquals(3, startsWithB);
    }

    @Test
    public void reduceTest() {
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        reduced.ifPresent(s -> assertEquals("aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2", s));
    }
}
