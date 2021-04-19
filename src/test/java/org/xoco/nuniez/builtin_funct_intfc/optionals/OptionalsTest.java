package org.xoco.nuniez.builtin_funct_intfc.optionals;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalsTest {
    @Test
    public void optionalsTest() {
        Optional<String> optional = Optional.of("bam");

        assertTrue(optional.isPresent());
        assertEquals("bam", optional.get());
        assertEquals("bam", optional.orElse("fallback"));

        optional.ifPresent((s) -> assertEquals('b', s.charAt(0)));
    }
}
