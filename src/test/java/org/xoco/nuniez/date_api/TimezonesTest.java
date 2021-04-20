package org.xoco.nuniez.date_api;

import org.junit.Test;

import java.time.ZoneId;

public class TimezonesTest {
    @Test
    public void timezonesTest() {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        System.out.println(zone1.getRules());
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone2.getRules());
    }
}
