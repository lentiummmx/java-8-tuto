package org.xoco.nuniez.funct_intfc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convert() {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        assertEquals(123, converted.intValue());
    }

    @Test
    public void convertV2() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        assertEquals(123, converted.intValue());
    }
}