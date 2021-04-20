package org.xoco.nuniez.date_api;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LocalTimeTest {
    ZoneId zone1;
    ZoneId zone2;

    @Before
    public void setUp() throws Exception {
        zone1 = ZoneId.of("Europe/Berlin");
        zone2 = ZoneId.of("Brazil/East");
    }

    @Test
    public void localTimeTest() {
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        assertFalse(now1.isBefore(now2));

        long hourBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        assertEquals(-4, hourBetween);  // should be -3, but adjusted to local daylight save-time
        assertEquals(-299, minutesBetween); // should be -239, but adjusted to local daylight save-time
    }

    @Test
    public void localTimeFactoryTest() {
        LocalTime late  = LocalTime.of(23, 59, 59);
        assertEquals("23:59:59", late.toString());

        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        assertEquals("13:37", leetTime.toString());
    }
}
