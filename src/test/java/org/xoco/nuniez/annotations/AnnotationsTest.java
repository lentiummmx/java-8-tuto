package org.xoco.nuniez.annotations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnnotationsTest {
    @Test
    public void hintTest() {
        Hint hint = PersonVariant2.class.getAnnotation(Hint.class);
        assertNull(hint);

        Hints hints = PersonVariant2.class.getAnnotation(Hints.class);
        assertEquals(2, hints.value().length);

        Hint[] hints1 = PersonVariant1.class.getAnnotationsByType(Hint.class);
        assertEquals(2, hints1.length);

        Hint[] hints2 = PersonVariant2.class.getAnnotationsByType(Hint.class);
        assertEquals(2, hints2.length);
    }
}
