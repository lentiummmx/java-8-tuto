package org.xoco.nuniez.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LambdaTest {

    List<String> names;

    @Before
    public void setUp() throws Exception {
        names = Arrays.asList("xenia","anna","mike","peter");
    }

    @Test
    public void comparatorWithoutLambda() {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        assertEquals(Arrays.asList("xenia","peter","mike","anna"), names);
    }

    @Test
    public void comparatorWithLambdaV1() {
        Collections.sort(names, (String o1, String o2) -> {
            return o2.compareTo(o1);
        });

        assertEquals(Arrays.asList("xenia","peter","mike","anna"), names);
    }

    @Test
    public void comparatorWithLambdaV2() {
        Collections.sort(names, (String o1, String o2) -> o2.compareTo(o1));

        assertEquals(Arrays.asList("xenia","peter","mike","anna"), names);
    }

    @Test
    public void comparatorWithLambdaV3() {
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

        assertEquals(Arrays.asList("xenia","peter","mike","anna"), names);
    }
}
