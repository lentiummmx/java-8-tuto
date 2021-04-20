package org.xoco.nuniez.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamApiTest {
    private List<String> userNames;

    @Before
    public void setUp() throws Exception {
        userNames = Stream.of("mzheng", "tChang", "aWang").collect(Collectors.toList());
    }

    @Test
    public void testFilterWithPredicate() {
        Predicate<String> startWithA = name -> name.startsWith("a");
        List<String> startWithANames = userNames.stream().filter(startWithA)
                .collect(Collectors.toList());
        assertEquals("aWang", startWithANames.get(0));
    }

    @Test
    public void test_int_stream_sum() {
        int sum = IntStream.of(1,3,5,7,9).sum();
        assertEquals(25, sum);
    }

    @Test
    public void test_map_with_method_reference() {
        List<String> uppercaseNames = userNames.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        assertTrue(uppercaseNames.contains("MZHENG"));
        assertTrue(uppercaseNames.contains("TCHANG"));
        assertTrue(uppercaseNames.contains("AWANG"));
    }

    @Test
    public void test_stream_min_max() {
        Comparator<String> comparator = Comparator.comparing(String::length);
        Optional<String> shortestName = userNames.stream().min(comparator);
        assertTrue(shortestName.isPresent());
        assertEquals("aWang", shortestName.get());

        Optional<String> longestName = userNames.stream().max(comparator);
        assertTrue(longestName.isPresent());
        assertEquals("mzheng", longestName.get());
    }

    @Test
    public void test_stream_foreach() {
        // Internal iteration
        userNames.stream().forEach(System.out::println);
    }

    @Test
    public void test_stream_sort() {
        List<String> sortedNames = userNames.stream().sorted().collect(Collectors.toList());
        assertEquals("aWang", sortedNames.get(0));
        assertEquals("mzheng", sortedNames.get(1));
        assertEquals("tChang", sortedNames.get(2));
    }
}
