package org.xoco.nuniez.builtin_funct_intfc;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PredicatesTest {
    @Test
    public void predicates() {
        Predicate<String> predicate = s -> s.length() > 0;

        assertTrue(predicate.test("foo"));
        assertFalse(predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
