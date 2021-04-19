package org.xoco.nuniez.funct_intfc;

/**
 * The code is also valid if the @FunctionalInterface annotation would be ommited.
 * @param <F> from
 * @param <T> to
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
