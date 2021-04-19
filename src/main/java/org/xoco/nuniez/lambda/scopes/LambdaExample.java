package org.xoco.nuniez.lambda.scopes;

import org.xoco.nuniez.funct_intfc.Converter;

public class LambdaExample {
    static int outerStaticNum;
    int outerNum;

    Converter<Integer, String> testInstanceFieldScope() {
        Converter<Integer, String> stringConverter = from -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        return  stringConverter;
    }

    Converter<Integer, String> testStaticVarScope() {
        Converter<Integer, String> stringConverter = from -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        return  stringConverter;
    }
}
