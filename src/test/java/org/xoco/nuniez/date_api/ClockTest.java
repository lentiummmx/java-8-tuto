package org.xoco.nuniez.date_api;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ClockTest {
    @Test
    public void clockTest() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
    }

    @Test
    public void instantTest() {
        Instant instant = Clock.systemDefaultZone().instant();
        Date legacyDate = Date.from(instant);
        assertTrue(Date.from(instant) instanceof Date);
    }
}
