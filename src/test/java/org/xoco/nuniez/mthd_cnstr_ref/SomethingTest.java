package org.xoco.nuniez.mthd_cnstr_ref;

import org.junit.Test;
import org.xoco.nuniez.funct_intfc.Converter;

import static org.junit.Assert.*;

public class SomethingTest {

    /**
     * Static method
     */
    @Test
    public void convert() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        assertEquals(123, converted.intValue());
    }

    /**
     * Object method
     */
    @Test
    public void startsWith() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        assertEquals("J", converted);
    }
}