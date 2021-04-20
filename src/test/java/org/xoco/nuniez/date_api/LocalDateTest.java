package org.xoco.nuniez.date_api;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class LocalDateTest {
    @Test
    public void localDateTest() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.SEPTEMBER, 15);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        assertEquals(DayOfWeek.MONDAY, dayOfWeek);
    }

    @Test
    public void localDateFactoryTest() {
        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        assertEquals("2014-12-24", xmas.toString());
    }
}
