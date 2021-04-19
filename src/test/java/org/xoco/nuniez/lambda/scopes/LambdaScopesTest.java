package org.xoco.nuniez.lambda.scopes;

import org.junit.Ignore;
import org.junit.Test;
import org.xoco.nuniez.funct_intfc.Converter;

import static org.junit.Assert.assertEquals;

public class LambdaScopesTest {

    @Test
    public void accessingFinalLocalVars() {
        final int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);

        assertEquals("3", stringConverter.convert(2));
    }

    @Test
    public void accessingLocalVars() {
        int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);

        assertEquals("3", stringConverter.convert(2));
    }

    /**
     * Ignored and commented as it will not compile due num is not final or effectively final
     */
    @Ignore
    @Test
    public void accessingLocalVarsCompileError() {
        /*
        int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);    // <- Compilation error
        num = 3;

        assertEquals("3", stringConverter.convert(2));
         */
    }

    /**
     * Ignored and commented as default methods cannot be accessed from within lambda expressions. The following code does not compile
     */
    @Ignore
    @Test
    public void accessingDefaultIntfcMethodsCompileError() {
        // Formula formula = (a) -> sqrt(a * 100);
    }
}
