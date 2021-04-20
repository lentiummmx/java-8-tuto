package org.xoco.nuniez.date_api;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocalDateTimeTest {
    LocalDateTime sylvester;

    @Before
    public void setUp() throws Exception {
        sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
    }

    @Test
    public void localDateTimeTest() {
        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        assertEquals(DayOfWeek.WEDNESDAY, dayOfWeek);

        Month month = sylvester.getMonth();
        assertEquals(Month.DECEMBER, month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        assertEquals(1439, minuteOfDay);
    }

    @Test
    public void localDateTimeInstantTest() {
        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        Date legacy = Date.from(instant);
        assertTrue(Date.from(instant) instanceof Date);
    }

    @Test
    public void localDateTimeFactoryTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        assertEquals("Nov 03, 2014 - 07:13", string);
    }
}
