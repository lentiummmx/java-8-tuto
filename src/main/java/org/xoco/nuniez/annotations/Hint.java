package org.xoco.nuniez.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
