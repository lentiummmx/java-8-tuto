package org.xoco.nuniez.date_api;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateApiTest {
    @Test
    public void test_LocalDateTime_to_formatted_string() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime now() in ISO_LOCAL_DATE_TIME: " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now));
        System.out.println("LocalDateTime now() in ISO_LOCAL_DATE: " + DateTimeFormatter.ISO_LOCAL_DATE.format(now));
    }

    @Test
    public void testZonedDateTime() {
        ZonedDateTime chicagoTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("America/Chicago is at :: " + DateTimeFormatter.ISO_ZONED_DATE_TIME.format(chicagoTime));
        System.out.println("America/Chicago offset: " + chicagoTime.getOffset());

        ZonedDateTime chongqingTime = ZonedDateTime.now(ZoneId.of("Asia/Chongqing"));
        System.out.println("Asia/Chongqing is at :: " + DateTimeFormatter.ISO_ZONED_DATE_TIME.format(chongqingTime));
        System.out.println("Asia/Chongqing offset: " + chongqingTime.getOffset());
    }

    @Test
    public void testFormattedStringToLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime d = LocalDateTime.parse("2021-04-05 12:15", formatter);
        System.out.println("Date: " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(d));
    }

    @Test
    public void testAddDaysToLocalDateTime() {
        LocalDateTime newDate = LocalDateTime.now().plus(Period.ofDays(3));
        System.out.println("Three days later: " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(newDate));
    }
}
