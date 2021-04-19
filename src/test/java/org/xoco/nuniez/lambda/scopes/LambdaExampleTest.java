package org.xoco.nuniez.lambda.scopes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaExampleTest {

    @Test
    public void testInstanceFieldScope() {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.testInstanceFieldScope().convert(1);
        assertEquals(23, lambdaExample.outerNum);
    }

    @Test
    public void testStaticVarScope() {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.testStaticVarScope().convert(1);
        assertEquals(72, LambdaExample.outerStaticNum);
    }
}