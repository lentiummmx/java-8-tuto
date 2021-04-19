package org.xoco.nuniez.intfcs;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormulaTest {

    @Test
    public void calculate() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        assertEquals(100.0, formula.calculate(100), 1);
    }

    @Test
    public void sqrt() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        assertEquals(4.0, formula.sqrt(14), 10);
    }
}