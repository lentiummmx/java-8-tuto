package org.xoco.nuniez.builtin_funct_intfc.functions;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FunctionsTest {
    @Test
    public void functionsTest() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        assertEquals("123", backToString.apply("123"));
    }
}
